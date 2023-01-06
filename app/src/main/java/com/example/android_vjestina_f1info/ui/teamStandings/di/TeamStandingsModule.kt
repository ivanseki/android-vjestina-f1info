package com.example.android_vjestina_f1info.ui.teamStandings.di

import com.example.android_vjestina_f1info.ui.teamStandings.TeamStandingsViewModel
import com.example.android_vjestina_f1info.ui.teamStandings.mapper.ITeamStandingsMapper
import com.example.android_vjestina_f1info.ui.teamStandings.mapper.TeamStandingsMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamStandingsModule = module {
    viewModel {
        TeamStandingsViewModel(
            teamsRepository = get(),
            teamStandingsMapper = get()
        )
    }
    single<ITeamStandingsMapper> { TeamStandingsMapper() }
}