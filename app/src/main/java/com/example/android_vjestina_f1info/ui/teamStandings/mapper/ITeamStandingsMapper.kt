package com.example.android_vjestina_f1info.ui.teamStandings.mapper

import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.ui.teamStandings.TeamStandingsViewState

interface ITeamStandingsMapper {
    fun toTeamStandingsState(teamStandings: List<Team>): TeamStandingsViewState
}