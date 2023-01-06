package com.example.android_vjestina_f1info.data.repository

import com.example.android_vjestina_f1info.mock.F1InfoMock
import com.example.android_vjestina_f1info.mock.FavoritesDBMock
import com.example.android_vjestina_f1info.model.Driver
import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.model.TeamDetails
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

class FakeF1InfoRepository(
    private val ioDispatcher: CoroutineDispatcher,
) : F1InfoRepository {
    private val fakeTeams = F1InfoMock.getTeamsList().toMutableList()

    private val teams: Flow<List<Team>> = FavoritesDBMock.favoriteIds
        .mapLatest { favoriteIds ->
            fakeTeams.map { it.copy(isFavorite = favoriteIds.contains(it.id)) }
        }
        .flowOn(ioDispatcher)

    private val fakeDrivers = F1InfoMock.getDriversList().toMutableList()

    private val drivers: Flow<List<Driver>> = FavoritesDBMock.favoriteIds
        .mapLatest { favoriteIds ->
            fakeDrivers.map { it.copy(id = favoriteIds.first()) }
        }.flowOn(ioDispatcher)

    override fun teams() = teams

    override fun teamStandings() = teams

    override fun driverStandings() = drivers

    override fun teamDetails(teamId: Int): Flow<TeamDetails> =
        FavoritesDBMock.favoriteIds.mapLatest { favoriteIds ->
            val teamDetails = F1InfoMock.getTeamDetails(teamId)
            teamDetails.copy(
                team = teamDetails.team.copy(
                    isFavorite = favoriteIds.contains(teamDetails.team.id)
                )
            )
        }

    override fun favoriteTeams(): Flow<List<Team>> = teams.map {
        it.filter { fakeTeam -> fakeTeam.isFavorite }
    }

    override suspend fun addTeamToFavorites(teamId: Int) {
        FavoritesDBMock.insert(teamId)
    }

    override suspend fun removeTeamFromFavorites(teamId: Int) {
        FavoritesDBMock.delete(teamId)
    }

    override suspend fun toggleFavorite(teamId: Int) =
        if (FavoritesDBMock.favoriteIds.value.contains(teamId)) {
            removeTeamFromFavorites(teamId)
        } else {
            addTeamToFavorites(teamId)
        }
}