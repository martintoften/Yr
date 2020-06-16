package com.martintoften.yr.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martintoften.yr.network.model.SearchResponse
import com.martintoften.yr.repository.Result
import com.martintoften.yr.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private const val DEBOUNCE_DELAY = 400L

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val channel = ConflatedBroadcastChannel<String>()

    val search = MutableStateFlow<SearchResponse?>(null)

    init {
        initSearchListener()
    }

    private fun initSearchListener() {
        viewModelScope.launch {
            channel.asFlow()
                .debounce(DEBOUNCE_DELAY)
                .map { searchRepository.search(it) }
                .flowOn(Dispatchers.IO)
                .collect { handleSearchResult(it) }
        }
    }

    private fun handleSearchResult(result: Result<SearchResponse>) {
        when (result) {
            is Result.Success -> handleSuccess(result)
            is Result.Error -> handleError(result)
        }
    }

    private fun handleSuccess(success: Result.Success<SearchResponse>) {
        search.value = success.value
    }

    private fun handleError(error: Result.Error) {
        // TODO: Pass to view
    }

    fun search(value: String) {
        viewModelScope.launch {
            channel.send(value)
        }
    }
}