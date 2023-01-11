package com.example.android_vjestina_f1info.ui.driverStandings.mapper

import com.example.android_vjestina_f1info.model.DriverStanding
import com.example.android_vjestina_f1info.ui.driverStandings.DriverStandingsViewState

interface IDriverStandingsMapper {
    fun toDriverStandingsState(driverStandings: List<DriverStanding>): DriverStandingsViewState
}