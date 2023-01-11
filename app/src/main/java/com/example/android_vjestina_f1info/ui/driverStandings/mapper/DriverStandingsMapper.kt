package com.example.android_vjestina_f1info.ui.driverStandings.mapper

import com.example.android_vjestina_f1info.model.DriverStanding
import com.example.android_vjestina_f1info.ui.component.DriverCardViewState
import com.example.android_vjestina_f1info.ui.driverStandings.DriverStandingsViewState

class DriverStandingsMapper : IDriverStandingsMapper {
    override fun toDriverStandingsState(driverStandings: List<DriverStanding>): DriverStandingsViewState {
        return DriverStandingsViewState(driverStandings.map { driver ->
            DriverCardViewState(
                id = driver.id,
                name = driver.name,
                number = driver.number,
                imageUrl = driver.imageUrl,
                points = driver.points,
                position = driver.position
            )
        })
    }
}