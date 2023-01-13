package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.TeamStanding
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiTeamStanding(
    @SerialName("team")
    val team: ApiTeamStandingTeam,

    @SerialName("position")
    val position: Int,

    @SerialName("points")
    val points: Int
) {
    fun toTeamStanding() = TeamStanding(
        id = team.id,
        name = team.name,
        logoUrl = team.logoUrl,
        position = position,
        points = points
    )
}