package com.example.android_vjestina_f1info.model

data class TeamDetails(
    val team: Team,
    val base: String,
    val first_team_entry: Int,
    val world_championships: Int,
    val pole_positions: Int,
    val fastest_laps: Int,
    val president: String,
    val director: String,
    val technical_manager: String,
    val chassis: String,
    val engine: String
)
