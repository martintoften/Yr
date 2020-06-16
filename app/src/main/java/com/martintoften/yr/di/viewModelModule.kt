package com.martintoften.yr.di

import com.martintoften.yr.ui.viewModel.ForecastViewModel
import com.martintoften.yr.ui.viewModel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
    viewModel { ForecastViewModel(get()) }
}