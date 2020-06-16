package com.martintoften.yr.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martintoften.yr.network.model.NetworkResult
import com.martintoften.yr.network.model.SearchResponse
import com.martintoften.yr.repository.SearchRepository
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.ui.model.ViewState
import com.martintoften.yr.ui.viewModel.mapper.mapToViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

private const val DEBOUNCE_DELAY = 400L

class SearchViewModel(
    private val searchRepository: SearchRepository
) : ViewModel() {

    private val channel = ConflatedBroadcastChannel<String>()
    private var lastQuery = ""

    private val _search = MutableStateFlow<ViewState<List<ViewLocation>>?>(null)
    val search = _search as StateFlow<ViewState<List<ViewLocation>>?>

    init {
        initSearchListener()
    }

    private fun initSearchListener() {
        viewModelScope.launch {
            channel.asFlow()
                .debounce(DEBOUNCE_DELAY)
                .onEach { _search.value = ViewState.Loading() }
                .map { searchRepository.search(it) }
                .flowOn(Dispatchers.IO)
                .collect { handleSearchResult(it) }
        }
    }

    private fun handleSearchResult(result: NetworkResult<SearchResponse>) {
        when (result) {
            is NetworkResult.Success -> {
                val viewLocations = result.value.mapToViewModel()
                _search.value = ViewState.Success(viewLocations)
            }
            is NetworkResult.Error -> {
                _search.value = ViewState.Failure(result.throwable)
            }
        }
    }

    fun search(query: String) {
        if (query.length <= 1 || lastQuery == query) {
            return
        }

        lastQuery = query

        viewModelScope.launch {
            channel.send(query)
        }
    }
}