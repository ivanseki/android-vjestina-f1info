package com.example.android_vjestina_f1info.mock

import com.example.android_vjestina_f1info.model.*

object F1InfoMock {

    fun getTeamStandingsList(): List<TeamStanding> = listOf(
        TeamStanding(
            id = 1,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            points = 759,
            position = 1
        ),
        TeamStanding(
            id = 2,
            name = "McLaren Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/2.png",
            points = 159,
            position = 5
        ),
        TeamStanding(
            id = 3,
            name = "Scuderia Ferrari",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/3.png",
            points = 554,
            position = 2
        ),
        TeamStanding(
            id = 4,
            name = "Mercedes-AMG Petronas",
            logoUrl = "https://media.api-sports.io/formula-1/teams/5.png",
            points = 515,
            position = 3
        ),
        TeamStanding(
            id = 5,
            name = "Haas F1 Team",
            logoUrl = "https://media-2.api-sports.io/formula-1/teams/14.png",
            points = 37,
            position = 8
        )
    )

    fun getTeamDetails(): TeamDetails = TeamDetails(
        team = Team(
            id = 1,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true,
        ),
        drivers = listOf(
            Driver(
                id = 1,
                name = "Max Verstappen",
                imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
                abbr = "VER"
            ),
            Driver(
                id = 2,
                name = "Max Verstappen",
                imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
                abbr = "VER"
            )
        ),
        base = "Milton Keynes, United Kingdom",
        first_team_entry = 1997,
        world_championships = 5,
        pole_positions = 80,
        fastest_laps = 84,
        president = "Dietrich Mateschitz",
        director = "Christian Horner",
        technical_manager = "Pierre Waché",
        chassis = "RB18",
        engine = "Red Bull Powertrains"
    )

    fun getTeamDetails(teamId: Int): TeamDetails = TeamDetails(
        team = getTeams().first { it.id == teamId },
        drivers = listOf(
            Driver(
                id = 1,
                name = "Max Verstappen",
                imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
                abbr = "VER"
            ),
            Driver(
                id = 2,
                name = "Max Verstappen",
                imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
                abbr = "VER"
            )
        ),
        base = "Milton Keynes, United Kingdom",
        first_team_entry = 1997,
        world_championships = 5,
        pole_positions = 80,
        fastest_laps = 84,
        president = "Dietrich Mateschitz",
        director = "Christian Horner",
        technical_manager = "Pierre Waché",
        chassis = "RB18",
        engine = "Red Bull Powertrains"
    )

    fun getDriverStandingList(): List<DriverStanding> = listOf(
        DriverStanding(
            id = 1,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        ),
        DriverStanding(
            id = 2,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        ),
        DriverStanding(
            id = 3,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        ),
        DriverStanding(
            id = 4,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        ),
        DriverStanding(
            id = 5,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        ),
        DriverStanding(
            id = 6,
            name = "Max Verstappen",
            number = 1,
            imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
            points = 454,
            position = 1
        )
    )

    fun getDriver(): Driver = Driver(
        id = 1,
        name = "Max Verstappen",
        imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png",
        abbr = "VER"
    )

    fun getTeam(): Team = Team(
        id = 1,
        name = "Red Bull Racing",
        logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
        isFavorite = true
    )

    fun getTeams(): List<Team> = listOf(
        Team(
            id = 1,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true
        ),
        Team(
            id = 2,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true
        ),
        Team(
            id = 3,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true
        )
    )
}