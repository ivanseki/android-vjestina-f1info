package com.example.android_vjestina_f1info.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.android_vjestina_f1info.mock.F1InfoMock

data class TeamDetailsCardViewState(
    val id: Int,
    val name: String,
    val logoUrl: String?,
    val isFavorite: Boolean
)

@Composable
fun TeamDetailsCard(
    teamDetailsCardViewState: TeamDetailsCardViewState,
    modifier: Modifier,
    onClick: () -> Unit = {},
    onFavouriteButtonClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5F)
            ) {
                Text(
                    text = teamDetailsCardViewState.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier
                        .weight(0.5F)
                        .padding(start = 10.dp, top = 20.dp, end = 10.dp, bottom = 10.dp)
                )

                FavoriteButton(
                    modifier = Modifier
                        .padding(10.dp)
                        .size(45.dp),
                    isFavourite = teamDetailsCardViewState.isFavorite,
                    onClick = { onFavouriteButtonClick(teamDetailsCardViewState.id) }
                )
            }

            AsyncImage(
                model = teamDetailsCardViewState.logoUrl,
                contentDescription = teamDetailsCardViewState.name,
                modifier = Modifier
                    .weight(0.5F)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun TeamDetailsCardPreview() {
    val team = F1InfoMock.getTeam()

    TeamDetailsCard(
        teamDetailsCardViewState = TeamDetailsCardViewState(
            id = team.id,
            name = team.name,
            logoUrl = team.logoUrl,
            isFavorite = true
        ),
        modifier = Modifier
            .width(350.dp)
            .height(125.dp),
        onClick = { },
        onFavouriteButtonClick = { }
    )
}