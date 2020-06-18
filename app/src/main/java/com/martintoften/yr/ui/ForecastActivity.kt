package com.martintoften.yr.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.martintoften.yr.R
import com.martintoften.yr.extensions.toast
import com.martintoften.yr.ui.list.forecast.ForecastAdapter
import com.martintoften.yr.ui.model.ViewForecast
import com.martintoften.yr.ui.model.ViewLocation
import com.martintoften.yr.ui.model.ViewState
import com.martintoften.yr.ui.viewModel.ForecastViewModel
import com.martintoften.yr.ui.viewModel.factory.ForecastViewModelFactory
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import org.koin.android.ext.android.get

class ForecastActivity : AppCompatActivity() {

    private val forecastViewModel by viewModels<ForecastViewModel> {
        val location = getLocation() ?: throw IllegalStateException("Location id must not be null")
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
        initToolbar()
        initList()
        initObservers()
    }

    private fun initToolbar() {
        val location = getLocation() ?: return
        toolbar.title = location.name
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun initList() {
        forecastList.adapter = ForecastAdapter()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            forecastViewModel.forecast
                .filterNotNull()
                .collect { handleForecast(it) }
        }
    }

    private fun handleForecast(result: ViewState<List<ViewForecast>>) {
        when (result) {
            is ViewState.Success -> {
                val adapter = forecastList.adapter as? ForecastAdapter?
                adapter?.setItems(result.data)
                overlay.isOverlayVisible(false)
            }
            is ViewState.Failure -> {
                Log.e("Forecast", result.throwable.toString())
                overlay.isOverlayVisible(false)
                toast(getString(R.string.forecast_error))
            }
            is ViewState.Loading -> {
                overlay.isOverlayVisible(true)
            }
        }
    }

    private fun getLocation(): ViewLocation? = intent.extras?.getParcelable(LOCATION)
}