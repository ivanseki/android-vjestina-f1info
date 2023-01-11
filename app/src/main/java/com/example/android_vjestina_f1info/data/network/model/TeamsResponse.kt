package com.example.android_vjestina_f1info.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamsResponse(
    @SerialName("teams")
    val teams: List<ApiTeam>
)