package com.example.android_vjestina_f1info.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DriverStandingsResponse(
    @SerialName("rankings")
    val driver_standings: List<ApiDriverStanding>
)