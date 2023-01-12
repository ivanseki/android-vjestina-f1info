package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.data.network.model.*

interface IF1InfoService {
    suspend fun fetchTeams(): TeamsResponse

    suspend fun fetchTeamStandings(): TeamStandingsResponse

    suspend fun fetchDriverStandings(): DriverStandingsResponse

    suspend fun fetchTeamDetails(teamId: Int): ApiTeamDetails

    suspend fun fetchTeamDetailsDrivers(teamId: Int): TeamDetailsDriversResponse
}