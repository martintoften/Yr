package com.martintoften.yr.network

import com.martintoften.yr.network.model.forecast.ForecastResponse
import com.martintoften.yr.network.model.search.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YrApi {
    @GET("locations/search")
    suspend fun search(
        @Query("q") query: String,
        @Query("language") type: String = "nn"
    ): Response<SearchResponse>

    @GET("locations/{id}/forecast")
    suspend fun forecast(
        @Path("id") locationId: String
    ): Response<ForecastResponse>
}