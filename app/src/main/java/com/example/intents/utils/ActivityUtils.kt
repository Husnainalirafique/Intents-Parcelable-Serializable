package com.example.intents.utils

import android.os.Build
import android.view.View
import android.view.WindowInsetsController

fun setStatusBarAppearance(view: View) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        val insetsController = view.windowInsetsController
        insetsController?.setSystemBarsAppearance(
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
        )
    }
}
