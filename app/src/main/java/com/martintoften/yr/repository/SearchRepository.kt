package com.martintoften.yr.repository

import com.martintoften.yr.network.model.search.SearchResponse
import com.martintoften.yr.network.SearchApi
import com.martintoften.yr.network.model.NetworkResult

class SearchRepository(
    private val searchApi: SearchApi
) {
    suspend fun search(query: String): NetworkResult<SearchResponse> {
        return try {
            val response = searchApi.search(query = query)
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