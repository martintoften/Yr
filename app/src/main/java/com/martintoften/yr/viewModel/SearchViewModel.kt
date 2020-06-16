package com.martintoften.yr.viewModel

import com.martintoften.yr.network.model.SearchResponse
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martintoften.yr.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
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

    private fun handleSearchResult(result: SearchResponse) {
        Log.d("Search result", result.totalResults.toString())
    }

    fun search(value: String) {
        viewModelScope.launch {
            channel.send(value)
        }
    }
}