package com.example.lazylayout

import androidx.annotation.DrawableRes

data class Hewan(
    val id: Int,
    val name: String,
    val description: String,
    @param:DrawableRes val imageRes: Int = R.drawable.ic_launcher_foreground,
)
