package com.martintoften.yr.di

import com.martintoften.yr.network.buildSearchApi
import org.koin.dsl.module

val networkModule = module {
    single { buildSearchApi() }
}