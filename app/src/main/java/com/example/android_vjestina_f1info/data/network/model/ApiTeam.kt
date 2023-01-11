package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.Team
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiTeam(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("logo")
    val logoUrl: String?
) {
    fun toTeam(isFavorite: Boolean) = Team(
        id = id,
        name = name,
        logoUrl = logoUrl,
        isFavorite = isFavorite
    )
}