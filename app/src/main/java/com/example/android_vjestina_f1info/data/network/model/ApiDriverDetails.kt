package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.Driver
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiDriverDetails(
    @SerialName("driver")
    val driver: ApiDriver
)