package com.example.android_vjestina_f1info.ui.teamDetailsScreen.di

import com.example.android_vjestina_f1info.ui.teamDetailsScreen.TeamDetailsViewModel
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper.ITeamDetailsMapper
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper.TeamDetailsMapper
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val teamDetailsModule = module {
    viewModel { (teamId: Int) ->
        TeamDetailsViewModel(
            teamRepository = get(),
            teamDetailsMapper = get(),
            teamId = teamId
        )
    }
    single<ITeamDetailsMapper> { TeamDetailsMapper() }
}