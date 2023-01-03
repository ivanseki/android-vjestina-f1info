package com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper

import com.example.android_vjestina_f1info.model.TeamDetails
import com.example.android_vjestina_f1info.ui.component.TeamDetailsDriverCardViewState
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.TeamDetailsViewState

class TeamDetailsMapper : ITeamDetailsMapper {
    override fun toTeamDetailsViewState(teamDetails: TeamDetails): TeamDetailsViewState {
        return TeamDetailsViewState(
            team = teamDetails.team,
            drivers = toTeamDetailsDriverCardViewState(teamDetails),
            base = teamDetails.base,
            first_team_entry = teamDetails.first_team_entry,
            world_championships = teamDetails.world_championships,
            pole_positions = teamDetails.pole_positions,
            fastest_laps = teamDetails.fastest_laps,
            president = teamDetails.president,
            director = teamDetails.director,
            technical_manager = teamDetails.technical_manager,
            chassis = teamDetails.chassis,
            engine = teamDetails.engine
        )
    }

    private fun toTeamDetailsDriverCardViewState(teamDetails: TeamDetails) =
        teamDetails.drivers.map { driver ->
            TeamDetailsDriverCardViewState(
                id = driver.id,
                name = driver.name,
                imageUrl = driver.imageUrl,
                countryName = driver.countryName
            )
        }
}