package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.DriverStanding
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiDriverStanding(
    @SerialName("position")
    val position: Int,

    @SerialName("driver")
    val driver: ApiDriverStandingDriver,

    @SerialName("points")
    val points: Int?
) {
    fun toDriverStanding() = DriverStanding(
        id = driver.id,
        name = driver.name,
        number = driver.number,
        imageUrl = driver.imageUrl,
        position = position,
        points = points
    )
}