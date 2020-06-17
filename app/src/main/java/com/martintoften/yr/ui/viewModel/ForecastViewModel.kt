package com.martintoften.yr.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martintoften.yr.network.model.NetworkResult
import com.martintoften.yr.network.model.forecast.ForecastResponse
import com.martintoften.yr.repository.ForecastRepository
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.ui.model.ViewState
import com.martintoften.yr.ui.viewModel.mapper.sortGroupAndMapForecasts
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForecastViewModel(
    locationId: String,
    private val forecastRepository: ForecastRepository
) : ViewModel() {

    val forecast = MutableStateFlow<ViewState<List<ViewForecast>>?>(null)

    init {
        getForecast(locationId)
    }

    private fun getForecast(locationId: String) {
        viewModelScope.launch {
            forecast.value = ViewState.Loading()
            val result = forecastRepository.getForecast(locationId)
            handleForecastResult(result)
        }
    }

    private fun handleForecastResult(result: NetworkResult<ForecastResponse>) {
        when (result) {
            is NetworkResult.Success -> {
                val intervals = result.value.sortGroupAndMapForecasts()
                forecast.value = ViewState.Success(intervals)
            }
            is NetworkResult.Error -> {
                forecast.value = ViewState.Failure(result.throwable)
            }
        }
    }
}