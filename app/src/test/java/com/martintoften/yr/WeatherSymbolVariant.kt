package com.martintoften.yr

import com.martintoften.yr.util.WeatherVariant
import com.martintoften.yr.util.getWeatherVariant
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherSymbolVariant {

    @Test
    fun `null`() {
        val result = getWeatherVariant(null)
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `empty`() {
        val result = getWeatherVariant("")
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `sun`() {
        val result = getWeatherVariant("sun")
        assertEquals(WeatherVariant.DAY, result)
    }

    @Test
    fun `daytime`() {
        val result = getWeatherVariant("daytime")
        assertEquals(WeatherVariant.DAY, result)
    }

    @Test
    fun `d`() {
        val result = getWeatherVariant("d")
        assertEquals(WeatherVariant.DAY, result)
    }

    @Test
    fun `night`() {
        val result = getWeatherVariant("night")
        assertEquals(WeatherVariant.NIGHT, result)
    }

    @Test
    fun `moon`() {
        val result = getWeatherVariant("moon")
        assertEquals(WeatherVariant.NIGHT, result)
    }

    @Test
    fun `n`() {
        val result = getWeatherVariant("n")
        assertEquals(WeatherVariant.NIGHT, result)
    }

    @Test
    fun `polar nights`() {
        val result = getWeatherVariant("polar nights")
        assertEquals(WeatherVariant.POLAR, result)
    }

    @Test
    fun `polar`() {
        val result = getWeatherVariant("polar")
        assertEquals(WeatherVariant.POLAR, result)
    }

    @Test
    fun `winter sun`() {
        val result = getWeatherVariant("winter sun")
        assertEquals(WeatherVariant.POLAR, result)
    }

    @Test
    fun `m`() {
        val result = getWeatherVariant("m")
        assertEquals(WeatherVariant.POLAR, result)
    }

    @Test
    fun `winter su`() {
        val result = getWeatherVariant("winter su")
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `winter pola`() {
        val result = getWeatherVariant("pola")
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `winter`() {
        val result = getWeatherVariant("winter")
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `day`() {
        val result = getWeatherVariant("day")
        assertEquals(WeatherVariant.NONE, result)
    }

    @Test
    fun `moo`() {
        val result = getWeatherVariant("moo")
        assertEquals(WeatherVariant.NONE, result)
    }
}