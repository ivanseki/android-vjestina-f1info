package com.example.android_vjestina_f1info.data.network.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class TeamDetailsDriversResponse(
    @SerialName("response")
    val drivers: List<ApiDriver>
)