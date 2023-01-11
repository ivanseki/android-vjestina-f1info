package com.example.android_vjestina_f1info.data.repository

import com.example.android_vjestina_f1info.model.DriverStanding
import com.example.android_vjestina_f1info.model.TeamStanding
import com.example.android_vjestina_f1info.model.TeamDetails
import kotlinx.coroutines.flow.Flow

interface F1InfoRepository {
    fun teams(): Flow<List<TeamStanding>>

    fun teamStandings(): Flow<List<TeamStanding>>

    fun driverStandings(): Flow<List<DriverStanding>>

    fun teamDetails(teamId: Int): Flow<TeamDetails>

    fun favoriteTeams(): Flow<List<TeamStanding>>

    suspend fun addTeamToFavorites(teamId: Int)

    suspend fun removeTeamFromFavorites(teamId: Int)

    suspend fun toggleFavorite(teamId: Int)
}