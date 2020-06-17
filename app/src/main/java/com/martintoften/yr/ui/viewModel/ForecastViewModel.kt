package com.martintoften.yr.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martintoften.yr.network.model.NetworkResult
import com.martintoften.yr.network.model.forecast.ForecastResponse
import com.martintoften.yr.repository.ForecastRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForecastViewModel(
    locationId: String,
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    init {
        getForecast(locationId)
    }

    val forecast = MutableStateFlow("")

    private fun getForecast(locationId: String) {
        viewModelScope.launch {
            val result = forecastRepository.getForecast(locationId)
            handleForecastResult(result)
        }
    }

    private fun handleForecastResult(result: NetworkResult<ForecastResponse>) {
        when (result) {
            is NetworkResult.Success -> {
                val forecast = result.value
            }
            is NetworkResult.Error -> {
                Log.e("ERROR", result.throwable.toString())
            }
        }
    }
}