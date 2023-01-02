package com.example.android_vjestina_f1info.mock

import com.example.android_vjestina_f1info.model.Driver
import com.example.android_vjestina_f1info.model.Team
import com.example.android_vjestina_f1info.model.TeamDetails

object F1InfoMock {

    fun getTeamsList(): List<Team> = listOf(
        Team(
            id = 1,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true
        ),
        Team(
            id = 2,
            name = "McLaren Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/2.png",
            isFavorite = false
        ),
        Team(
            id = 3,
            name = "Scuderia Ferrari",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/3.png",
            isFavorite = false
        ),
        Team(
            id = 4,
            name = "Mercedes-AMG Petronas",
            logoUrl = "https://media.api-sports.io/formula-1/teams/5.png",
            isFavorite = false
        ),
        Team(
            id = 5,
            name = "Haas F1 Team",
            logoUrl = "https://media-2.api-sports.io/formula-1/teams/14.png",
            isFavorite = true
        )
    )

    fun getTeamDetails(): TeamDetails = TeamDetails(
        team = Team(
            id = 1,
            name = "Red Bull Racing",
            logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
            isFavorite = true
        ),
        drivers = List(2) {
            Driver(
                id = 1,
                name = "Max Verstappen",
                abbr = "VER",
                number = 1,
                imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png"
            )
        },
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

    fun getDriver(): Driver = Driver(
        id = 1,
        name = "Max Verstappen",
        abbr = "VER",
        number = 1,
        imageUrl = "https://media-1.api-sports.io/formula-1/drivers/25.png"
    )

    fun getTeam(): Team = Team(
        id = 1,
        name = "Red Bull Racing",
        logoUrl = "https://media-1.api-sports.io/formula-1/teams/1.png",
        isFavorite = true
    )
}