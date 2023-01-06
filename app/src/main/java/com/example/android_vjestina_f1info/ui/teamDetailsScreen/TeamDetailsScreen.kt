package com.example.android_vjestina_f1info.ui.teamDetailsScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.android_vjestina_f1info.mock.F1InfoMock
import com.example.android_vjestina_f1info.ui.component.FavoriteButton
import com.example.android_vjestina_f1info.ui.component.TeamDetailsDriverCard
import com.example.android_vjestina_f1info.ui.component.TeamDetailsDriverCardViewState
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper.ITeamDetailsMapper
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.mapper.TeamDetailsMapper
import com.example.android_vjestina_f1info.ui.theme.spacing

private val teamDetailsMapper: ITeamDetailsMapper = TeamDetailsMapper()

val teamDetailsViewState = teamDetailsMapper.toTeamDetailsViewState(F1InfoMock.getTeamDetails())

@Composable
fun TeamDetailsRoute(
    viewModel: TeamDetailsViewModel
) {
    val teamDetailsViewState: TeamDetailsViewState by viewModel.teamDetailsViewState.collectAsState()

    TeamDetailsScreen(
        team = teamDetailsViewState,
        onFavoriteButtonClick = { teamId -> viewModel.toggleFavorite(teamId) }
    )
}

@Composable
fun TeamDetailsScreen(
    modifier: Modifier = Modifier,
    team: TeamDetailsViewState,
    onFavoriteButtonClick: (Int) -> Unit
) {
    Column(
        modifier = modifier
            .verticalScroll(state = rememberScrollState())
            .padding(start = 5.dp, end = 5.dp)
    ) {
        TeamDetailsHeader(
            id = team.team.id,
            teamName = team.team.name,
            logoUrl = team.team.logoUrl,
            isFavorite = team.team.isFavorite,
            onFavoriteButtonClick = onFavoriteButtonClick
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )

        TeamDetailsOverview(
            base = team.base,
            first_team_entry = team.first_team_entry,
            world_championships = team.world_championships,
            pole_positions = team.pole_positions,
            fastest_laps = team.fastest_laps,
            president = team.president,
            director = team.director,
            technical_manager = team.technical_manager,
            chassis = team.chassis,
            engine = team.engine
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )

        TeamDetailsDrivers(
            drivers = team.drivers
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.medium)
        )
    }
}

@Composable
fun TeamDetailsHeader(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium),
    id: Int,
    teamName: String,
    logoUrl: String?,
    isFavorite: Boolean,
    onFavoriteButtonClick: (Int) -> Unit
) {
    AsyncImage(
        model = logoUrl,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    )

    Spacer(
        modifier = Modifier
            .height(MaterialTheme.spacing.medium)
    )

    Row(
        modifier = modifier
            .height(50.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = teamName,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        FavoriteButton(
            isFavourite = isFavorite,
            onClick = { onFavoriteButtonClick(id) },
            modifier = Modifier
                .padding(start = 5.dp)
        )
    }
}

@Composable
fun TeamDetailsOverview(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    base: String,
    first_team_entry: Int,
    world_championships: Int,
    pole_positions: Int,
    fastest_laps: Int,
    president: String,
    director: String,
    technical_manager: String,
    chassis: String,
    engine: String
) {
    Column(
        modifier = modifier
            .padding(start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium)
    ) {
        Text(
            text = base,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "First appearance: $first_team_entry",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "World champions won: $world_championships",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Number of pole positions: $pole_positions",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Number of fastest laps: $fastest_laps",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "President: $president",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Director: $director",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Technical manager: $technical_manager",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Chassis: $chassis",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )

        Text(
            text = "Engine: $engine",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 5.dp, bottom = 5.dp)
        )
    }
}

@Composable
fun TeamDetailsDrivers(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    drivers: List<TeamDetailsDriverCardViewState>
) {
    Column(
        modifier = modifier
            .padding(start = MaterialTheme.spacing.medium, end = MaterialTheme.spacing.medium)
    ) {
        Text(
            modifier = modifier
                .fillMaxWidth(),
            text = "Drivers",
            maxLines = 1,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier
                .height(MaterialTheme.spacing.small)
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
            userScrollEnabled = true
        ) {
            items(
                items = drivers,
                key = { driver -> driver.id }
            ) { driver ->
                TeamDetailsDriverCard(
                    teamDetailsDriverCardViewState = driver,
                    modifier = Modifier
                        .size(
                            width = 125.dp,
                            height = 200.dp
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamDetailsScreenPreview() {
    TeamDetailsScreen(
        team = teamDetailsViewState,
        onFavoriteButtonClick = { })
}