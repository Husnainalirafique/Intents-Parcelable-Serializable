package com.example.intents

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class Person(
    val name: String
) : Parcelable

