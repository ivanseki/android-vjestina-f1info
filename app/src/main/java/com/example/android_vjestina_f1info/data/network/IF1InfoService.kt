package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.data.network.model.*

interface IF1InfoService {
    suspend fun fetchTeams(): ApiHomeTeamsResponse

    suspend fun fetchTeamStandings(): ApiTeamStandingsResponse

    suspend fun fetchDriverStandings(): ApiDriverStandingsResponse

    suspend fun fetchTeamDetails(teamId: Int): ApiTeamDetailsResponse

    suspend fun fetchTeamDetailsDrivers(teamId: Int): ApiTeamDetailsDriversResponse
}