package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.data.network.model.ApiTeamDetails
import com.example.android_vjestina_f1info.data.network.model.DriverStandingsResponse
import com.example.android_vjestina_f1info.data.network.model.TeamStandingsResponse
import com.example.android_vjestina_f1info.data.network.model.TeamsResponse

interface IF1InfoService {
    suspend fun fetchTeams(): TeamsResponse

    suspend fun fetchTeamStandings(): TeamStandingsResponse

    suspend fun fetchDriverStandings(): DriverStandingsResponse

    suspend fun fetchTeamDetails(): ApiTeamDetails
}