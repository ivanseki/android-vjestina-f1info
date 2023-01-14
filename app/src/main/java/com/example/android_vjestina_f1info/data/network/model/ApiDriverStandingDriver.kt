package com.example.android_vjestina_f1info.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiDriverStandingDriver(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("number")
    val number: Int?,

    @SerialName("image")
    val imageUrl: String?
)