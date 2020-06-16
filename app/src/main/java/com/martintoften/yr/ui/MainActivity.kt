package com.martintoften.yr.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.martintoften.yr.R
import com.martintoften.yr.network.model.SearchResponse
import com.martintoften.yr.ui.model.ViewState
import com.martintoften.yr.ui.viewModel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val searchViewModel by viewModel<SearchViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        initSearch()
        initObservers()
    }

    private fun initSearch() {
        search.doOnTextChanged { text, _, _, _ ->
            searchViewModel.search(text.toString())
        }
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            searchViewModel.search
                .filterNotNull()
                .collect { handleSearchResult(it) }
        }
    }

    private fun handleSearchResult(result: ViewState<SearchResponse>) {
        when (result) {
            is ViewState.Loading -> {
                Log.d("RESULT", "LOADING")
            }
            is ViewState.Success -> {
                Log.d("RESULT", "SUCCESS")
            }
            is ViewState.Failure -> {
                Log.d("RESULT", "FAILURE")
            }
        }
    }
}