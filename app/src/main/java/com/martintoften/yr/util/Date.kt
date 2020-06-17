package com.martintoften.yr.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss"

fun parseDate(value: String, format: String = DATE_FORMAT): Date? {
    return try {
        SimpleDateFormat(format, Locale.getDefault()).parse(value)
    } catch (e: ParseException) {
        null
    }
}