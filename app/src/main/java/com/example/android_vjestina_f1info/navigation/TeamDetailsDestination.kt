package com.example.android_vjestina_f1info.navigation

const val TEAM_DETAILS_ROUTE = "MovieDetails"
const val TEAM_ID_KEY = "movieId"
const val TEAM_DETAILS_ROUTE_WITH_PARAMS = "$TEAM_DETAILS_ROUTE/{$TEAM_ID_KEY}"

object TeamDetailsDestination : F1InfoAppDestination(TEAM_DETAILS_ROUTE_WITH_PARAMS) {
    fun createNavigationRoute(teamId: Int): String = "$TEAM_DETAILS_ROUTE/$teamId"
}