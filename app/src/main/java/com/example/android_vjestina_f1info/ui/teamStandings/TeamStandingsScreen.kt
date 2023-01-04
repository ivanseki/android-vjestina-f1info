package com.example.android_vjestina_f1info.ui.teamStandings

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.android_vjestina_f1info.R
import com.example.android_vjestina_f1info.mock.F1InfoMock.getTeamsList
import com.example.android_vjestina_f1info.ui.component.TeamCard
import com.example.android_vjestina_f1info.ui.teamStandings.mapper.ITeamStandingsMapper
import com.example.android_vjestina_f1info.ui.teamStandings.mapper.TeamStandingsMapper
import com.example.android_vjestina_f1info.ui.theme.spacing

private val teamStandingsMapper: ITeamStandingsMapper = TeamStandingsMapper()

val teamStandingsViewState = teamStandingsMapper.toTeamStandingsState(getTeamsList())

@Composable
fun TeamStandingsRoute() {
    val teamStandingsViewState by remember { mutableStateOf(teamStandingsViewState) }

    TeamStandingsScreen(
        teams = teamStandingsViewState
    )
}

@Composable
fun TeamStandingsScreen(
    modifier: Modifier = Modifier,
    teams: TeamStandingsViewState,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.team_standings),
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Text(
                text = stringResource(R.string.position),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(0.4F)
                    .padding(5.dp)
            )

            Text(
                text = stringResource(R.string.name),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(0.43F)
                    .padding(5.dp)
            )

            Text(
                text = stringResource(R.string.points),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(0.17F)
                    .padding(5.dp)
            )
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.small),
            contentPadding = PaddingValues(horizontal = MaterialTheme.spacing.small),
            userScrollEnabled = true
        ) {
            items(
                items = teams.teamStandings,
                key = { team -> team.id }
            ) { team ->
                TeamCard(
                    teamCardViewState = team,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TeamStandingsScreenPreview() {
    val teamStandingsMapper: ITeamStandingsMapper = TeamStandingsMapper()

    TeamStandingsScreen(
        teams = teamStandingsMapper.toTeamStandingsState(getTeamsList())
    )
}