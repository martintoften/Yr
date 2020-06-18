package com.martintoften.yr

import com.martintoften.yr.util.getWeatherType
import org.junit.Assert.assertEquals
import org.junit.Test

class WeatherSymbolType {

    @Test
    fun `-1`() {
        val result = getWeatherType(-1)
        assertEquals("-1", result)
    }

    @Test
    fun `00`() {
        val result = getWeatherType(0)
        assertEquals("00", result)
    }

    @Test
    fun `01`() {
        val result = getWeatherType(1)
        assertEquals("01", result)
    }

    @Test
    fun `02`() {
        val result = getWeatherType(2)
        assertEquals("02", result)
    }

    @Test
    fun `03`() {
        val result = getWeatherType(3)
        assertEquals("03", result)
    }

    @Test
    fun `10`() {
        val result = getWeatherType(10)
        assertEquals("10", result)
    }

    @Test
    fun `19`() {
        val result = getWeatherType(19)
        assertEquals("19", result)
    }

    @Test
    fun `101`() {
        val result = getWeatherType(101)
        assertEquals("101", result)
    }
}