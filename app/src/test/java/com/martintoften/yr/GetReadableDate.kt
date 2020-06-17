package com.martintoften.yr

import com.martintoften.yr.util.getReadableDate
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date
import java.util.Locale

class GetReadableDate {

    @Test
    fun `valid timestamp - Wednesday 17 June`() {
        val date = Date(1592401484560)
        val result = getReadableDate(date, Locale.ENGLISH)
        assertEquals("Wednesday 17. June", result)
    }

    @Test
    fun `valid timestamp - Tuesday 9 June`() {
        val date = Date(708040800000)
        val result = getReadableDate(date, Locale.ENGLISH)
        assertEquals("Tuesday 9. June", result)
    }

    @Test
    fun `valid timestamp Thursday 1 January`() {
        val date = Date(0)
        val result = getReadableDate(date, Locale.ENGLISH)
        assertEquals("Thursday 1. January", result)
    }

    @Test
    fun `valid timestamp`() {
        val date = Date(-1)
        val result = getReadableDate(date, Locale.ENGLISH)
        assertEquals("Thursday 1. January", result)
    }
}