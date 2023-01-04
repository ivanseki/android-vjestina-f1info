package com.example.android_vjestina_f1info.ui.driverStandings

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
import com.example.android_vjestina_f1info.mock.F1InfoMock
import com.example.android_vjestina_f1info.ui.component.DriverCard
import com.example.android_vjestina_f1info.ui.driverStandings.mapper.DriverStandingsMapper
import com.example.android_vjestina_f1info.ui.driverStandings.mapper.IDriverStandingsMapper
import com.example.android_vjestina_f1info.ui.teamStandings.TeamStandingsScreen
import com.example.android_vjestina_f1info.ui.teamStandings.teamStandingsViewState
import com.example.android_vjestina_f1info.ui.theme.spacing

private val driverStandingsMapper: IDriverStandingsMapper = DriverStandingsMapper()

val driverStandingsViewState =
    driverStandingsMapper.toDriverStandingsState(F1InfoMock.getDriversList())

@Composable
fun DriverStandingsRoute() {
    val driverStandingsViewState by remember { mutableStateOf(driverStandingsViewState) }

    DriverStandingsScreen(
        drivers = driverStandingsViewState
    )
}

@Composable
fun DriverStandingsScreen(
    modifier: Modifier = Modifier,
    drivers: DriverStandingsViewState
) {
    Column(
        modifier = modifier
    ) {
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
                    .weight(0.3F)
                    .padding(5.dp)
            )

            Text(
                text = stringResource(R.string.number),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(0.20F)
                    .padding(5.dp)
            )

            Text(
                text = stringResource(R.string.name),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(0.38F)
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
                items = drivers.driverStandings,
                key = { driver -> driver.id }
            ) { driver ->
                DriverCard(
                    driverCardViewState = driver,
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
private fun DriverStandingsScreenPreview() {
    val driverStandingsMapper: IDriverStandingsMapper = DriverStandingsMapper()

    DriverStandingsScreen(
        drivers = driverStandingsMapper.toDriverStandingsState(F1InfoMock.getDriversList())
    )
}