package com.example.android_vjestina_f1info.navigation

import com.example.android_vjestina_f1info.R

const val HOME_ROUTE = "Home"
const val DRIVER_STANDINGS_ROUTE = "Driver standings"
const val TEAM_STANDINGS_ROUTE = "Team standings"

sealed class NavigationItem(
    override val route: String,
    val selectedIconId: Int,
    val unselectedIconId: Int,
    val labelId: Int,
) : F1InfoAppDestination(route) {

    object HomeDestination : NavigationItem(
        route = HOME_ROUTE,
        selectedIconId = R.drawable.ic_home_selected,
        unselectedIconId = R.drawable.ic_home_notselected,
        labelId = R.string.home,
    )

    object DriverStandingsDestination : NavigationItem(
        route = DRIVER_STANDINGS_ROUTE,
        selectedIconId = R.drawable.ic_drivers_selected,
        unselectedIconId = R.drawable.ic_drivers_notselected,
        labelId = R.string.driver_standings,
    )

    object TeamStandingsDestination : NavigationItem(
        route = TEAM_STANDINGS_ROUTE,
        selectedIconId = R.drawable.ic_teams_selected,
        unselectedIconId = R.drawable.ic_teams_notselected,
        labelId = R.string.team_standings,
    )
}