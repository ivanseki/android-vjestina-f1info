package com.example.android_vjestina_f1info.data.network

import com.example.android_vjestina_f1info.data.network.model.ApiTeamDetails
import com.example.android_vjestina_f1info.data.network.model.DriverStandingsResponse
import com.example.android_vjestina_f1info.data.network.model.TeamStandingsResponse
import com.example.android_vjestina_f1info.data.network.model.TeamsResponse
import io.ktor.client.*
import io.ktor.client.request.*
import okhttp3.OkHttpClient
import okhttp3.Request

class F1InfoService(private val client: OkHttpClient) : IF1InfoService {

    val request = Request.Builder()
        .get()
        .addHeader("X-RapidAPI-Key", "7cc27589a7mshcb29eacccff6aeap186cd5jsn016ceaf74ef5")
        .addHeader("X-RapidAPI-Host", "api-formula-1.p.rapidapi.com")

    override suspend fun fetchTeams(): TeamsResponse{
        request.url("https://api-formula-1.p.rapidapi.com/teams").build()

        return client.newCall(request).execute()
    }

    override suspend fun fetchTeamStandings(): TeamStandingsResponse{

    }

    override suspend fun fetchDriverStandings(): DriverStandingsResponse{

    }

    override suspend fun fetchTeamDetails(): ApiTeamDetails{

    }
}