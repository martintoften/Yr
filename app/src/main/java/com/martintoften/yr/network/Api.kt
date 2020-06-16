package com.martintoften.yr.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

private const val SEARCH_API_URL = "https://www.yr.no/api/v0/"

fun buildYrApi(): YrApi {
    val client = getHttpClient(listOf(getLoggingInterceptor()))
    val contentType = "application/json".toMediaType()

    val retrofit = Retrofit.Builder()
        .client(client.build())
        .baseUrl(SEARCH_API_URL)
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()

    return retrofit.create(YrApi::class.java)
}

private fun getHttpClient(interceptors: List<Interceptor> = emptyList()): OkHttpClient.Builder {
    val builder = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .readTimeout(120, TimeUnit.SECONDS)

    interceptors.forEach { builder.addInterceptor(it) }

    return builder
}

private fun getLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}