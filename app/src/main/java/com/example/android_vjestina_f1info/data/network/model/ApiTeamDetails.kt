package com.example.android_vjestina_f1info.data.network.model

import com.example.android_vjestina_f1info.model.Driver
import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.model.TeamDetails
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiTeamDetails(
    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("logo")
    val logoUrl: String?,

    @SerialName("base")
    val base: String?,

    @SerialName("first_team_entry")
    val first_team_entry: Int?,

    @SerialName("world_championships")
    val world_championships: Int?,

    @SerialName("pole_positions")
    val pole_positions: Int?,

    @SerialName("fastest_laps")
    val fastest_laps: Int?,

    @SerialName("president")
    val president: String?,

    @SerialName("director")
    val director: String?,

    @SerialName("technical_manager")
    val technical_manager: String?,

    @SerialName("chassis")
    val chassis: String?,

    @SerialName("engine")
    val engine: String?
) {
    fun toTeamDetails(isFavorite: Boolean, drivers: List<Driver>) = TeamDetails(
        team = Team(
            id = id,
            name = name,
            logoUrl = logoUrl,
            isFavorite = isFavorite
        ),
        drivers = drivers,
        base = base,
        first_team_entry = first_team_entry,
        world_championships = world_championships,
        pole_positions = pole_positions,
        fastest_laps = fastest_laps,
        president = president,
        director = director,
        technical_manager = technical_manager,
        chassis = chassis,
        engine = engine
    )
}