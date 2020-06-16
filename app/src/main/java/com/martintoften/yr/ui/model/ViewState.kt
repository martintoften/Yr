package com.martintoften.yr.ui.model

sealed class ViewState<out T> {
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Loading<out T>(val partialData: T? = null) : ViewState<T>()
    data class Failure(val throwable: Throwable? = null) : ViewState<Nothing>()
}
