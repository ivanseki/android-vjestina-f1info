package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.R
import com.example.android_vjestina_f1info.data.network.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

const val BASE_DRIVER_IMAGE_URL = "https://media-1.api-sports.io/formula-1/drivers"
const val BASE_TEAM_LOGO_URL = "https://media-2.api-sports.io/formula-1/teams"
private const val BASE_URL = "https://api-formula-1.p.rapidapi.com"

class F1InfoService(private val client: HttpClient) : IF1InfoService {

    override suspend fun fetchTeams(): TeamsResponse {
        return client.get("$BASE_URL/teams").body()
    }

    override suspend fun fetchTeamStandings(): TeamStandingsResponse {
        return client.get("$BASE_URL/teams?season=${R.string.season}").body()
    }

    override suspend fun fetchDriverStandings(): DriverStandingsResponse {
        return client.get("$BASE_URL/drivers?season=${R.string.season}").body()
    }

    override suspend fun fetchTeamDetails(teamId: Int): ApiTeamDetailsResponse {
        return client.get("$BASE_URL/teams?id=$teamId").body()
    }

    override suspend fun fetchTeamDetailsDrivers(teamId: Int): TeamDetailsDriversResponse {
        return client.get("$BASE_URL/drivers?season=${R.string.season}&team=$teamId").body()
    }
}