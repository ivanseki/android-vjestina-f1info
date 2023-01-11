package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.TeamStanding
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiTeamStanding(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("logo")
    val logoUrl: String?,

    @SerialName("position")
    val position: Int,

    @SerialName("points")
    val points: Int
) {
    fun toTeamStanding() = TeamStanding(
        id = id,
        name = name,
        logoUrl = logoUrl,
        position = position,
        points = points
    )
}
