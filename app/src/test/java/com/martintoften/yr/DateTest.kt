package com.martintoften.yr

import com.martintoften.yr.util.parseDate
import org.junit.Assert.assertEquals
import org.junit.Test

class DateTest {
    @Test
    fun `invalid date(123) - invalid format`() {
        val date = parseDate("123", "")
        assertEquals(null, date)
    }

    @Test
    fun `valid date(2020-06-17) - invalid format`() {
        val date = parseDate("2020-06-17T16:00:00+02:00", "")
        assertEquals(null, date)
    }

    @Test
    fun `invalid date(321) - valid format`() {
        val date = parseDate("321", "yyyy-MM-dd'T'HH:mm:ss")
        assertEquals(null, date)
    }

    @Test
    fun `valid date(2020-06-17) - valid format`() {
        val date = parseDate("2020-06-17T16:00:00+02:00", "yyyy-MM-dd'T'HH:mm:ss")
        assertEquals(date?.time, 1592402400000)
    }
}