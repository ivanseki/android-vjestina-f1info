package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.Driver
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiDriver(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("image")
    val imageUrl: String?,

    @SerialName("abbr")
    val abbr: String
) {
    fun toDriver() = Driver(
        id = id,
        name = name,
        imageUrl = imageUrl,
        abbr = abbr
    )
}