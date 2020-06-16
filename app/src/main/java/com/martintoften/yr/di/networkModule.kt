package com.martintoften.yr.di

import com.martintoften.yr.network.buildYrApi
import org.koin.dsl.module

val networkModule = module {
    single { buildYrApi() }
}