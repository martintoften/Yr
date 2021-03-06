package com.martintoften.yr.ui.viewModel.mapper

import com.martintoften.yr.network.model.forecast.ForecastResponse
import com.martintoften.yr.network.model.forecast.PrecipitationX
import com.martintoften.yr.network.model.forecast.SymbolX
import com.martintoften.yr.network.model.forecast.WindX
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.ui.model.ViewInterval
import com.martintoften.yr.ui.model.ViewPrecipitation
import com.martintoften.yr.ui.model.ViewWeatherSymbol
import com.martintoften.yr.ui.model.ViewWind
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
        return@map ViewInterval(
            date = date,
            temperature = it.temperature?.value ?: 0.0,
            weatherSymbol = it.symbol?.toViewModel(),
            precipitation = it.precipitation?.toViewModel(),
            wind = it.wind?.toViewModel()
        )
    }
}

fun SymbolX.toViewModel(): ViewWeatherSymbol? {
    if (n == null) return null
    return ViewWeatherSymbol(n, variable)
}

fun PrecipitationX.toViewModel(): ViewPrecipitation {
    return ViewPrecipitation(min ?: 0.0, max ?: 0.0)
}

fun WindX.toViewModel(): ViewWind? {
    if (direction == null) return null
    return ViewWind(direction, gust, speed)
}