package com.example.android_vjestina_f1info.ui.teamDetailsScreen

import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.model.TeamStanding
import com.example.android_vjestina_f1info.ui.component.TeamDetailsDriverCardViewState

data class TeamDetailsViewState(
    val team: Team,
    val drivers: List<TeamDetailsDriverCardViewState>,
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