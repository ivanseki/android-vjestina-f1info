package com.example.android_vjestina_f1info.ui.teamStandings.mapper

import com.example.android_vjestina_f1info.model.TeamStanding
import com.example.android_vjestina_f1info.ui.component.TeamCardViewState
import com.example.android_vjestina_f1info.ui.teamStandings.TeamStandingsViewState

class TeamStandingsMapper : ITeamStandingsMapper {
    override fun toTeamStandingsState(teamStandings: List<TeamStanding>): TeamStandingsViewState {
        return TeamStandingsViewState(teamStandings.map { team ->
            TeamCardViewState(
                id = team.id,
                name = team.name,
                logoUrl = team.logoUrl,
                points = team.points,
                position = team.position
            )
        })
    }
}