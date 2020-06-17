package com.martintoften.yr.extensions

import android.content.Context

fun Context.getDrawableIdByName(name: String): Int? {
    return try {
        resources.getIdentifier(name, "drawable", packageName)
    } catch (error: Throwable) {
        null
    }
}