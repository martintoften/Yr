package com.martintoften.yr.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.martintoften.yr.R
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.ui.viewModel.ForecastViewModel
import com.martintoften.yr.ui.viewModel.factory.ForecastViewModelFactory
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.get

class ForecastActivity : AppCompatActivity() {

    private val forecastViewModel by viewModels<ForecastViewModel> {
        val location = intent.extras?.getParcelable<ViewLocation>(LOCATION)
            ?: throw IllegalStateException("Location id must not be null")
        ForecastViewModelFactory(location.id, get())
    }

    companion object {
        const val LOCATION = "LOCATION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        init()
    }

    private fun init() {
        lifecycleScope.launchWhenStarted {
            forecastViewModel.forecast.collect { Log.d("hello", "") }
        }
    }
}