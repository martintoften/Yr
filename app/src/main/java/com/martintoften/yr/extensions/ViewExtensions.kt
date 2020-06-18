package com.martintoften.yr.extensions

import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import com.google.android.material.textfield.TextInputEditText

fun View.isVisible(bool: Boolean?, nonVisibleState: Int = View.GONE) {
    visibility = if (bool == true) View.VISIBLE else nonVisibleState
}

fun View.getString(@StringRes resId: Int, vararg formatArgs: Any?): String {
    return context.getString(resId, *formatArgs)
}

fun View.getPxSize(@DimenRes id: Int) = resources.getDimensionPixelSize(id)

fun View.getDrawableById(@DrawableRes id: Int) = ContextCompat.getDrawable(context, id)

fun TextInputEditText.getDrawableWithTint(@ColorInt tintColor: Int, @DrawableRes drawable: Int): Drawable? {
    val unwrappedDrawable = AppCompatResources.getDrawable(context, drawable) ?: return null
    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable)
    DrawableCompat.setTint(wrappedDrawable, tintColor)
    return wrappedDrawable
}