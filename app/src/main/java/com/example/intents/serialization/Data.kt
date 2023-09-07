package com.example.intents.serialization

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val id: Int
) : java.io.Serializable
