package com.martintoften.yr.repository

import com.martintoften.yr.network.model.search.SearchResponse
import com.martintoften.yr.network.YrApi
import com.martintoften.yr.network.model.NetworkResult

class SearchRepository(
    private val yrApi: YrApi
) {
    suspend fun search(query: String): NetworkResult<SearchResponse> {
        return try {
            val response = yrApi.search(query = query)
            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null) {
                NetworkResult.Success(responseBody)
            } else {
                NetworkResult.Error(response.code())
            }
        } catch (error: Throwable) {
            NetworkResult.Error(throwable = error)
        }
    }
}