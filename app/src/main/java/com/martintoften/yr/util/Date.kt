package com.martintoften.yr.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"
private const val READABLE_DATE_FORMAT = "EEEE d. MMMM"
private const val READABLE_HOURS_FORMAT = "HH:mm"

fun parseDate(value: String, format: String = DATE_FORMAT, locale: Locale = Locale.getDefault()): Date? {
    return try {
        SimpleDateFormat(format, locale).parse(value)
    } catch (e: ParseException) {
        null
    }
}

fun getReadableDate(date: Date, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(READABLE_DATE_FORMAT, locale).format(date)
}

fun getReadableHours(date: Date, locale: Locale = Locale.getDefault()): String {
    return SimpleDateFormat(READABLE_HOURS_FORMAT, locale).format(date)
}