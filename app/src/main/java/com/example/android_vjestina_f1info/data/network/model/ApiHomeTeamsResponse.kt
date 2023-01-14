package com.example.android_vjestina_f1info.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiHomeTeamsResponse(
    @SerialName("response")
    val teams: List<ApiHomeTeam>
)