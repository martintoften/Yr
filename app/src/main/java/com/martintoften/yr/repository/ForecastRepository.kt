package com.martintoften.yr.repository

import com.martintoften.yr.network.YrApi
import com.martintoften.yr.network.model.NetworkResult
import com.martintoften.yr.network.model.forecast.ForecastResponse

class ForecastRepository(
    private val yrApi: YrApi
) {
    suspend fun getForecast(locationId: String): NetworkResult<ForecastResponse> {
        return try {
            val response = yrApi.forecast(locationId = locationId)
            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error(response.code())
            }
        } catch (error: Throwable) {
            NetworkResult.Error(throwable = error)
        }
    }
}