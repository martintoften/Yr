package com.martintoften.yr

import com.martintoften.yr.util.getReadableHours
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Date
import java.util.Locale

class GetReadableHours {
    @Test
    fun `valid timestamp - 1544`() {
        val date = Date(1592401484560)
        val result = getReadableHours(date, Locale.ENGLISH)
        assertEquals("15:44", result)
    }

    @Test
    fun `valid timestamp - 0100`() {
        val date = Date(0)
        val result = getReadableHours(date, Locale.ENGLISH)
        assertEquals("01:00", result)
    }

    @Test
    fun `valid timestamp - 0059`() {
        val date = Date(-1)
        val result = getReadableHours(date, Locale.ENGLISH)
        assertEquals("00:59", result)
    }

    @Test
    fun `valid timestamp - 1633`() {
        val date = Date(1592404383199)
        val result = getReadableHours(date, Locale.ENGLISH)
        assertEquals("16:33", result)
    }
}