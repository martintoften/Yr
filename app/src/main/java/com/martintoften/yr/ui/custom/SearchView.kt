package com.martintoften.yr.ui.custom

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View.OnTouchListener
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.martintoften.yr.R
import com.martintoften.yr.extensions.getDrawableById
import com.martintoften.yr.extensions.getDrawableWithTint
import com.martintoften.yr.extensions.getPxSize
import com.martintoften.yr.extensions.getString

private const val DRAWABLE_RIGHT = 2

class SearchView : TextInputEditText {

    private val verticalPadding = getPxSize(R.dimen.margin_three_quarter)
    private val startPadding = getPxSize(R.dimen.margin_one_quarter)
    private val endPadding = getPxSize(R.dimen.margin_three_quarter)
    private val drawablePadding = getPxSize(R.dimen.margin_one_quarter)

    private var searchTextColor = 0
    private var searchHintColor = 0
    private var iconColor = 0
    private var iconColorActive = 0

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        parseAttributes(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        parseAttributes(attrs)
        init()
    }

    private fun parseAttributes(attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.SearchView)
        searchTextColor = a.getColor(R.styleable.SearchView_searchTextColor, 0)
        searchHintColor = a.getColor(R.styleable.SearchView_searchHintColor, 0)
        iconColor = a.getColor(R.styleable.SearchView_iconColor, 0)
        iconColorActive = a.getColor(R.styleable.SearchView_iconColorActive, 0)
        a.recycle()
    }

    private fun init() {
        initView()
        initDrawables()
        initDrawableStateListener()
        initClearListener()
    }

    private fun initView() {
        maxLines = 1
        hint = getString(R.string.search_location_hint)
        setBackgroundResource(R.drawable.input_background)
        setTextSize(TypedValue.COMPLEX_UNIT_PX, getPxSize(R.dimen.text_input).toFloat())
        setTextColor(searchTextColor)
        setHintTextColor(searchHintColor)
        setPadding(startPadding, verticalPadding, endPadding, verticalPadding)
    }

    private fun initDrawables() {
        compoundDrawablePadding = drawablePadding
        setCompoundDrawablesWithIntrinsicBounds(
            getDrawableById(R.drawable.ic_search),
            null,
            getDrawableById(R.drawable.ic_cross),
            null
        )
    }

    private fun initDrawableStateListener() {
        doOnTextChanged { input, _, _, _ ->
            val text = input.toString()
            updateDrawableState(text)
        }
    }

    private fun updateDrawableState(input: String) {
        val tintColor = if (input.isNotEmpty()) iconColorActive
        else iconColor

        val startDrawable = getDrawableWithTint(tintColor, R.drawable.ic_search)
        val endDrawable = getDrawableById(R.drawable.ic_cross)

        setCompoundDrawablesWithIntrinsicBounds(startDrawable, null, endDrawable, null)
    }

    private fun initClearListener() {
        setOnTouchListener(OnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableWidth = compoundDrawables[DRAWABLE_RIGHT].bounds.width()
                val drawablePadding = endPadding + drawablePadding
                if (event.rawX >= right - drawableWidth - drawablePadding) {
                    this@SearchView.setText("")
                    return@OnTouchListener true
                }
            }
            false
        })
    }
}