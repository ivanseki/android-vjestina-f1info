package com.example.android_vjestina_f1info.ui.home.mapper

import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.ui.home.HomeViewState

interface IHomeScreenMapper {
    fun toHomeViewState(teams: List<Team>): HomeViewState
}