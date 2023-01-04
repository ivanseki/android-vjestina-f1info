package com.example.android_vjestina_f1info.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_vjestina_f1info.R
import com.example.android_vjestina_f1info.mock.F1InfoMock
import com.example.android_vjestina_f1info.ui.component.TeamDetailsCard
import com.example.android_vjestina_f1info.ui.home.mapper.HomeScreenMapper
import com.example.android_vjestina_f1info.ui.home.mapper.IHomeScreenMapper
import com.example.android_vjestina_f1info.ui.theme.spacing

private val homeScreenMapper: IHomeScreenMapper = HomeScreenMapper()

val homeViewState = homeScreenMapper.toHomeViewState(F1InfoMock.getTeamsList())

@Composable
fun HomeRoute(
    onNavigateToTeamDetails: (Int) -> Unit
) {
    val homeViewState by remember { mutableStateOf(homeViewState) }

    HomeScreen(
        teams = homeViewState,
        onTeamCardClick = onNavigateToTeamDetails,
        onFavoriteClick = { }
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    teams: HomeViewState,
    onTeamCardClick: (Int) -> Unit,
    onFavoriteClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.medium),
        contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.small),
        userScrollEnabled = true
    ) {
        item {
            Text(
                text = stringResource(R.string.teams),
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        items(
            items = teams.teams,
            key = { team -> team.id }
        ) { team ->
            TeamDetailsCard(
                teamDetailsCardViewState = team,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                onClick = { onTeamCardClick(team.id) },
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