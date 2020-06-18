package com.martintoften.yr.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.File
import java.util.concurrent.TimeUnit

private const val SEARCH_API_URL = "https://www.yr.no/api/v0/"
private const val CACHE_SIZE = 5L * 1024L * 1024L

fun buildYrApi(cacheDir: File): YrApi {
    val interceptors = listOf(getLoggingInterceptor())
    val client = getHttpClient(cacheDir, interceptors)
    val converterFactory = buildConverterFactory()

    val retrofit = Retrofit.Builder()
        .client(client.build())
        .baseUrl(SEARCH_API_URL)
        .addConverterFactory(converterFactory)
        .build()

    return retrofit.create(YrApi::class.java)
}

private fun buildConverterFactory(): Converter.Factory {
    val contentType = "application/json".toMediaType()
    val jsonConfiguration = JsonConfiguration(ignoreUnknownKeys = true)
    val json = Json(jsonConfiguration)
    return json.asConverterFactory(contentType)
}

private fun getHttpClient(cacheDir: File, interceptors: List<Interceptor> = emptyList()): OkHttpClient.Builder {
    val builder = OkHttpClient.Builder()
        .connectTimeout(120, TimeUnit.SECONDS)
        .cache(buildCache(cacheDir))
        .readTimeout(120, TimeUnit.SECONDS)

    interceptors.forEach { builder.addInterceptor(it) }

    return builder
}

private fun buildCache(cacheDir: File): Cache {
    return Cache(directory = cacheDir, maxSize = CACHE_SIZE)
}

private fun getLoggingInterceptor(): HttpLoggingInterceptor {
    return HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}