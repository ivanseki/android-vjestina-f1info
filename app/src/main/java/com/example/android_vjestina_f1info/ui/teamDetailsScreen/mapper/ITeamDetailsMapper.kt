package com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper

import com.example.android_vjestina_f1info.model.TeamDetails
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.TeamDetailsViewState

interface ITeamDetailsMapper {
    fun toTeamDetailsViewState(team: TeamDetails): TeamDetailsViewState
}