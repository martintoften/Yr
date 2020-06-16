package com.martintoften.yr.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

private const val DEBOUNCE_DELAY = 400L

class SearchViewModel : ViewModel() {

    private val channel = ConflatedBroadcastChannel<String>()

    init {
        initSearchListener()
    }

    private fun initSearchListener() {
        viewModelScope.launch {
            channel.asFlow()
                .debounce(DEBOUNCE_DELAY)
                .map { it + "1" }
                .flowOn(Dispatchers.IO)
                .collect { handleSearchResult(it) }
        }
    }

    private fun handleSearchResult(result: String) {
        Log.d("Search result", result)
    }

    fun search(value: String) {
        viewModelScope.launch {
            channel.send(value)
        }
    }
}