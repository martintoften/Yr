package com.martintoften.yr.di

import com.martintoften.yr.network.buildYrApi
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.io.File

private const val CACHE_NAME = "network_cache"

val networkModule = module {
    single { buildYrApi(get()) }
    factory { File(androidContext().cacheDir, CACHE_NAME)  }
}

