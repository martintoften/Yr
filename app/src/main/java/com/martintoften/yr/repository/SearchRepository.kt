package com.martintoften.yr.repository

import com.martintoften.yr.network.model.SearchResponse
import com.martintoften.yr.network.SearchApi

sealed class Result<out T> {
    data class Success<out T>(val value: T): Result<T>()
    data class Error(val code: Int? = null, val throwable: Throwable? = null): Result<Nothing>()
}

class SearchRepository(
    private val searchApi: SearchApi
) {
    suspend fun search(query: String): Result<SearchResponse> {
        val response = searchApi.search(query = query)
        val responseBody = response.body()

        return if (response.isSuccessful && responseBody != null) {
            Result.Success(responseBody)
        } else {
            Result.Error(response.code())
        }
    }
}