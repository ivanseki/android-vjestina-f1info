package com.example.android_vjestina_f1info.data.repository

import com.example.android_vjestina_f1info.data.database.DbFavoriteTeam
import com.example.android_vjestina_f1info.data.database.IFavoriteTeamDao
import com.example.android_vjestina_f1info.data.network.BASE_TEAM_LOGO_URL
import com.example.android_vjestina_f1info.data.network.IF1InfoService
import com.example.android_vjestina_f1info.data.network.model.TeamStandingsResponse
import com.example.android_vjestina_f1info.model.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

class F1InfoRepository(
    private val f1InfoService: IF1InfoService,
    private val teamDao: IFavoriteTeamDao,
    private val bgDispatcher: CoroutineDispatcher
) : IF1InfoRepository {

    private val teams: Flow<List<Team>> = flow {
        emit(f1InfoService.fetchTeams().teams)
    }.flatMapLatest { apiTeams ->
        teamDao.getFavorites().map { favoriteTeams ->
            apiTeams.map { apiTeam ->
                apiTeam.toTeam(
                    isFavorite = favoriteTeams.any { it.id == apiTeam.id }
                )
            }
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )

    override fun teams(): Flow<List<Team>> = teams


    override fun teamStandings(): Flow<List<TeamStanding>> = flow {
        emit(f1InfoService.fetchTeamStandings().team_standings)
    }.flatMapLatest { apiTeamStandings ->
        flowOf(
            apiTeamStandings.map { apiTeamStanding ->
                TeamStanding(
                    id = apiTeamStanding.id,
                    name = apiTeamStanding.name,
                    logoUrl = apiTeamStanding.logoUrl,
                    points = apiTeamStanding.points,
                    position = apiTeamStanding.position
                )
            })
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )

/*
    override fun teamStandings(): Flow<List<TeamStanding>> = flow {
        emit(f1InfoService.fetchTeamStandings().team_standings)
    }.map {
        it.map { apiTeamStanding ->
            TeamStanding(
                id = apiTeamStanding.id,
                name = apiTeamStanding.name,
                logoUrl = apiTeamStanding.logoUrl,
                points = apiTeamStanding.points,
                position = apiTeamStanding.position
            )
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )*/

    override fun driverStandings(): Flow<List<DriverStanding>> = flow {
        emit(f1InfoService.fetchDriverStandings().driver_standings)
    }.map {
        it.map { apiDriverStanding ->
            DriverStanding(
                id = apiDriverStanding.id,
                name = apiDriverStanding.name,
                number = apiDriverStanding.number,
                imageUrl = apiDriverStanding.imageUrl,
                points = apiDriverStanding.points,
                position = apiDriverStanding.position
            )
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )

    override fun teamDetails(teamId: Int): Flow<TeamDetails> = flow {
        emit(
            f1InfoService.fetchTeamDetails(teamId).team to f1InfoService.fetchTeamDetailsDrivers(
                teamId
            ).drivers
        )
    }.flatMapLatest { (apiTeamDetails, apiTeamDetailsDrivers) ->
        teamDao.getFavorites().map { favoriteTeams ->
            apiTeamDetails.toTeamDetails(
                isFavorite = favoriteTeams.any { it.id == apiTeamDetails.id },
                drivers = apiTeamDetailsDrivers.map { apiDriver -> apiDriver.toDriver() }
            )
        }
    }.flowOn(bgDispatcher)

    /*
        override fun teamDetails(teamId: Int): Flow<TeamDetails> = flow {
            emit(f1InfoService.fetchTeamDetails(teamId).team)
        }.flatMapLatest { apiTeamDetails ->
            teamDao.getFavorites().map { favoriteTeams ->
                apiTeamDetails.toTeamDetails(
                    isFavorite = favoriteTeams.any { it.id == apiTeamDetails.id },
                    drivers = teamDetailsDrivers(teamId).toList().flatten()
                )
            }
        }.flowOn(bgDispatcher)
    */
    override fun teamDetailsDrivers(teamId: Int): Flow<List<Driver>> = flow {
        emit(f1InfoService.fetchTeamDetailsDrivers(teamId).drivers)
    }.map {
        it.map { apiDriver ->
            Driver(
                id = apiDriver.id,
                name = apiDriver.name,
                imageUrl = apiDriver.imageUrl,
                abbr = apiDriver.abbr
            )
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )

    private val favorites = teamDao.getFavorites().map {
        it.map { dbFavoriteTeam ->
            Team(
                id = dbFavoriteTeam.id,
                name = "",
                logoUrl = dbFavoriteTeam.logoUrl,
                isFavorite = true
            )
        }
    }.shareIn(
        scope = CoroutineScope(bgDispatcher),
        started = SharingStarted.WhileSubscribed(1000L),
        replay = 1
    )

    override fun favoriteTeams(): Flow<List<Team>> = favorites

    override suspend fun addTeamToFavorites(teamId: Int) {
        runBlocking(bgDispatcher) {
            teamDao.insertFavorite(
                favoriteTeam = DbFavoriteTeam(
                    id = teamId,
                    logoUrl = f1InfoService.fetchTeamDetails(teamId).team.logoUrl
                )
            )
        }
    }

    override suspend fun removeTeamFromFavorites(teamId: Int) {
        runBlocking(bgDispatcher) {
            teamDao.deleteFavorite(teamId)
        }
    }


    private suspend fun findTeam(teamId: Int): Team? {
        var team: Team? = null
        teams.toList().flatten().forEach {
            if (it.id == teamId)
                team = it
        }

        return team
    }

    override suspend fun toggleFavorite(teamId: Int) {
        runBlocking(bgDispatcher) {
            val team = findTeam(teamId)
            if (team?.isFavorite == true) {
                removeTeamFromFavorites(teamId)
            } else {
                addTeamToFavorites(teamId)
            }
        }
    }
}