package com.martintoften.yr.repository

import com.martintoften.yr.network.model.SearchResponse
import com.martintoften.yr.network.SearchApi

class SearchRepository(
    private val searchApi: SearchApi
) {
    suspend fun search(query: String): SearchResponse {
        return searchApi.search(query = query)
    }
}