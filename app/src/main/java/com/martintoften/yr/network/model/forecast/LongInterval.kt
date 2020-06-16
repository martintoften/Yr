package com.martintoften.yr.network.model.forecast

import kotlinx.serialization.Serializable

@Serializable
data class LongInterval(
    val cloudCover: CloudCover? = null,
    val dewPoint: DewPoint? = null,
    val end: String? = null,
    val feelsLike: FeelsLike? = null,
    val humidity: Humidity? = null,
    val precipitation: Precipitation? = null,
    val pressure: Pressure? = null,
    val start: String? = null,
    val symbol: Symbol? = null,
    val temperature: Temperature? = null,
    val uvIndex: UvIndex? = null,
    val wind: Wind? = null
)