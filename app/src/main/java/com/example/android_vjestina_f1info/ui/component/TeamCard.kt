package com.example.android_vjestina_f1info.ui.component

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

data class TeamCardViewState(
    val name: String,
    val logoUrl: String?,
    val points: Int
)

@Composable
fun TeamCard(
    teamCardViewState: TeamCardViewState,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(5.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = teamCardViewState.logoUrl,
                contentDescription = teamCardViewState.name,
                modifier = Modifier
                    .weight(0.3F)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = teamCardViewState.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .weight(0.5F)
                    .padding(10.dp)
            )

            Text(
                text = teamCardViewState.points.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .weight(0.2F)
                    .padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun TeamCardPreview() {
    val team = F1InfoMock.getTeam()
    val teamCardViewState = TeamCardViewState(
        name = team.name,
        logoUrl = team.logoUrl,
        points = 759
    )

    TeamCard(
        teamCardViewState = teamCardViewState,
        modifier = Modifier
            .width(350.dp)
            .height(60.dp)
    )
}