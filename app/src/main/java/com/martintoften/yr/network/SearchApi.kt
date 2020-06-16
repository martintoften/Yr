package com.martintoften.yr.network

import com.martintoften.yr.network.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {
    @GET("locations/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("language") type: String = "nn"
    ): SearchResponse
}