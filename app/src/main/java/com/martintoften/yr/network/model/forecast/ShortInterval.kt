package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class ShortInterval(
    val cloudCover: CloudCoverX? = null,
    val dewPoint: DewPointX? = null,
    val end: String? = null,
    val feelsLike: FeelsLikeX? = null,
    val humidity: HumidityX? = null,
    val precipitation: PrecipitationX? = null,
    val pressure: PressureX? = null,
    val start: String? = null,
    val symbol: SymbolX? = null,
    val temperature: TemperatureX? = null,
    val uvIndex: UvIndexX? = null,
    val wind: WindX? = null
)