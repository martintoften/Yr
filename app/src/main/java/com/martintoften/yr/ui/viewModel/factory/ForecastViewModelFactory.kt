package com.martintoften.yr.ui.viewModel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.martintoften.yr.repository.ForecastRepository
import com.martintoften.yr.ui.viewModel.ForecastViewModel

class ForecastViewModelFactory(
    private val locationId: String,
    private val forecastRepository: ForecastRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ForecastViewModel::class.java)) {
            return ForecastViewModel(locationId, forecastRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}