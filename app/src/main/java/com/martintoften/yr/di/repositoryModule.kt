package com.martintoften.yr.di

import com.martintoften.yr.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { SearchRepository(get()) }
}