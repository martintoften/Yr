package com.martintoften.yr.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.martintoften.yr.R
import com.martintoften.yr.extensions.isVisible
import kotlinx.android.synthetic.main.view_spinner.view.*

class SpinnerView : FrameLayout {
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.view_spinner, this)
        spinner.isVisible(false)
    }

    fun isSpinnerVisible(isVisible: Boolean) {
        spinner.isVisible(isVisible)
    }
}