package com.martintoften.yr.extensions

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

fun AppCompatActivity.toast(value: String) {
    Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
}