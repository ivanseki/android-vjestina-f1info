package com.example.android_vjestina_f1info.data.repository

import com.example.android_vjestina_f1info.model.*
import kotlinx.coroutines.flow.Flow

interface IF1InfoRepository {
    fun teams(): Flow<List<Team>>

    fun teamStandings(): Flow<List<TeamStanding>>

    fun driverStandings(): Flow<List<DriverStanding>>

    fun teamDetails(teamId: Int): Flow<TeamDetails>

    //fun teamDetailsDrivers(teamId: Int): Flow<List<Driver>>

    fun favoriteTeams(): Flow<List<Team>>

    suspend fun addTeamToFavorites(teamId: Int)

    suspend fun removeTeamFromFavorites(teamId: Int)

    suspend fun toggleFavorite(teamId: Int)
}