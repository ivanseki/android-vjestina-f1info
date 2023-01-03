package com.example.android_vjestina_f1info.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_vjestina_f1info.mock.F1InfoMock
import com.example.android_vjestina_f1info.ui.component.TeamDetailsCard
import com.example.android_vjestina_f1info.ui.home.mapper.HomeScreenMapper
import com.example.android_vjestina_f1info.ui.home.mapper.IHomeScreenMapper
import com.example.android_vjestina_f1info.ui.theme.spacing

private val homeScreenMapper: IHomeScreenMapper = HomeScreenMapper()

val homeViewState = homeScreenMapper.toHomeViewState(F1InfoMock.getTeamsList())

@Composable
fun TeamStandingsRoute() {
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    teams: HomeViewState,
    onTeamCardClick: () -> Unit,
    onFavoriteClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.small),
        userScrollEnabled = true
    ) {
        items(
            items = teams.teams,
            key = { team -> team.id }
        ) { team ->
            TeamDetailsCard(
                teamDetailsCardViewState = team,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                onClick = { onTeamCardClick() },
                onFavouriteButtonClick = { onFavoriteClick() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val homeScreenMapper: IHomeScreenMapper = HomeScreenMapper()

    HomeScreen(
        teams = homeScreenMapper.toHomeViewState(F1InfoMock.getTeamsList()),
        onTeamCardClick = { },
        onFavoriteClick = { }
    )
}