package com.example.android_vjestina_f1info.data.repository

import com.example.android_vjestina_f1info.model.Driver
import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.model.TeamDetails
import com.example.android_vjestina_f1info.ui.component.TeamDetailsCardViewState
import kotlinx.coroutines.flow.Flow

interface F1InfoRepository {
    fun teams(): Flow<List<TeamDetailsCardViewState>>
    fun teamStandings(): Flow<List<Team>>
    fun driverStandings(): Flow<List<Driver>>
    fun teamDetails(teamId: Int): Flow<TeamDetails>
    fun favoriteTeams(): Flow<List<TeamDetailsCardViewState>>
    suspend fun addTeamToFavorites(teamId: Int)
    suspend fun removeTeamFromFavorites(teamId: Int)
    suspend fun toggleFavorite(teamId: Int)
}