package com.martintoften.yr.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martintoften.yr.R
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.ui.viewModel.ForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ForecastActivity : AppCompatActivity() {

    private val forecastViewModel by viewModel<ForecastViewModel>()

    companion object {
        const val LOCATION = "LOCATION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        init()
    }

    private fun init() {
        val location = intent.extras?.getParcelable<ViewLocation>(LOCATION)
        initLocation(location)
    }

    private fun initLocation(location: ViewLocation?) {
        if (location != null) {
            forecastViewModel.getForecast(location.id)
        }
    }
}