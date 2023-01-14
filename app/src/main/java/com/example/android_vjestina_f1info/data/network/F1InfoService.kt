package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.data.network.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

const val BASE_DRIVER_IMAGE_URL = "https://media-1.api-sports.io/formula-1/drivers"
const val BASE_TEAM_LOGO_URL = "https://media-2.api-sports.io/formula-1/teams"
private const val BASE_URL = "https://api-formula-1.p.rapidapi.com"
private const val SEASON = "2022"

class F1InfoService(private val client: HttpClient) : IF1InfoService {

    override suspend fun fetchTeams(): ApiHomeTeamsResponse {
        return client.get("$BASE_URL/teams").body()
    }

    override suspend fun fetchTeamStandings(): ApiTeamStandingsResponse {
        return client.get("$BASE_URL/rankings/teams?season=$SEASON").body()
    }

    override suspend fun fetchDriverStandings(): ApiDriverStandingsResponse {
        return client.get("$BASE_URL/rankings/drivers?season=$SEASON").body()
    }

    override suspend fun fetchTeamDetails(teamId: Int): ApiTeamDetailsResponse {
        return client.get("$BASE_URL/teams?id=$teamId").body()
    }

    override suspend fun fetchTeamDetailsDrivers(teamId: Int): ApiTeamDetailsDriversResponse {
        return client.get("$BASE_URL/rankings/drivers?season=$SEASON&team=$teamId").body()
    }
}