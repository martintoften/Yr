package com.martintoften.yr.network.model

sealed class NetworkResult<out T> {
    data class Success<out T>(val value: T): NetworkResult<T>()
    data class Error(val code: Int? = null, val throwable: Throwable? = null): NetworkResult<Nothing>()
}