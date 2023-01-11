package com.example.android_vjestina_f1info.data.network

interface IF1InfoService {
    suspend fun fetchTeams(): TeamsResponse

    suspend fun fetchTeamStandings(): TeamStandingsResponse

    suspend fun fetchDriverStandings(): DriverStandingsResponse

    suspend fun fetchTeamDetails(): TeamDetailsResponse
}