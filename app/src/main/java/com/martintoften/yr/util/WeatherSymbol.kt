package com.martintoften.yr.util

private val dayValues = listOf("d", "sun", "daytime")
private val nightValues = listOf("n", "night", "moon")
private val polarValues = listOf("m", "polar nights", "polar", "winter sun")

enum class WeatherVariant(val value: String) {
    DAY("d"),
    NIGHT("n"),
    POLAR("m"),
    NONE("")
}

fun getWeatherType(value: Int): String {
    return String.format("%02d", value)
}

fun getWeatherVariant(value: String?): WeatherVariant {
    val lowercaseValue = value?.toLowerCase() ?: WeatherVariant.NONE
    return when {
        dayValues.contains(lowercaseValue) -> WeatherVariant.DAY
        nightValues.contains(lowercaseValue) -> WeatherVariant.NIGHT
        polarValues.contains(lowercaseValue) -> WeatherVariant.POLAR
        else -> WeatherVariant.NONE
    }
}