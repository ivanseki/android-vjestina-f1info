package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.DriverStanding
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiDriverStanding(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("number")
    val number: Int,

    @SerialName("logo")
    val imageUrl: String?,

    @SerialName("position")
    val position: Int,

    @SerialName("points")
    val points: Int
) {
    fun toDriverStanding() = DriverStanding(
        id = id,
        name = name,
        number = number,
        imageUrl = imageUrl,
        position = position,
        points = points
    )
}