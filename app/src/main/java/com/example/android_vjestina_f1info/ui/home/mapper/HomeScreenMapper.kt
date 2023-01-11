package com.example.android_vjestina_f1info.ui.home.mapper

import com.example.android_vjestina_f1info.model.TeamStanding
import com.example.android_vjestina_f1info.ui.component.TeamDetailsCardViewState
import com.example.android_vjestina_f1info.ui.home.HomeViewState

class HomeScreenMapper : IHomeScreenMapper {
    override fun toHomeViewState(teams: List<TeamStanding>): HomeViewState {
        return HomeViewState(teams.map { team ->
            TeamDetailsCardViewState(
                id = team.id,
                name = team.name,
                logoUrl = team.logoUrl,
                isFavorite = team.isFavorite
            )
        })
    }
}