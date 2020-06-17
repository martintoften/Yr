package com.martintoften.yr.ui.viewModel.mapper

import com.martintoften.yr.network.model.forecast.ForecastResponse
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.ui.model.ViewInterval
import com.martintoften.yr.util.parseDate

fun ForecastResponse.sortGroupAndMapForecasts(): List<ViewForecast> {
    return mapViewViewModel()
        .filterNotNull()
        .sortedBy { it.date.time }
        .groupBy { it.date.date }
        .map { ViewForecast(it.key, it.value) }
}

fun ForecastResponse.mapViewViewModel(): List<ViewInterval?> {
    return shortIntervals.map {
        val date = parseDate(
            it.start ?: return@map null
        ) ?: return@map null
        return@map ViewInterval(date)
    }
}