package com.joaopaulosanttos.fitcalc

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class MainItem(
    val id: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val txtStringId: Int
)
