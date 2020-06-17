package com.martintoften.yr.extensions

import android.view.View

fun View.isVisible(bool: Boolean?, nonVisibleState: Int = View.GONE) {
    visibility = if (bool == true) View.VISIBLE else nonVisibleState
}