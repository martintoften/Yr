package com.martintoften.yr.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.martintoften.yr.R
import com.martintoften.yr.extensions.isVisible

class SpinnerOverlay : FrameLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.view_spinner_overlay, this)
        setBackgroundResource(R.color.spinner_overlay_default)
        visibility = View.GONE
        isClickable = true
        isFocusable = true
    }

    fun isOverlayVisible(isVisible: Boolean) = isVisible(isVisible)
}