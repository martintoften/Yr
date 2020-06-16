package com.martintoften.yr.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {

    fun search(value: String) {
        Log.d("search", value)
        // TODO: Search for location
    }
}