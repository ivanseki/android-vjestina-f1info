package com.example.android_vjestina_f1info.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

data class TeamDetailsDriverCardViewState(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val countryName: String
)

@Composable
fun TeamDetailsDriverCard(
    teamDetailsDriverCardViewState: TeamDetailsDriverCardViewState,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column {
            AsyncImage(
                model = teamDetailsDriverCardViewState.imageUrl,
                contentDescription = teamDetailsDriverCardViewState.name,
                modifier = Modifier
                    .weight(0.7F),
                contentScale = ContentScale.Crop
            )

            Text(
                text = teamDetailsDriverCardViewState.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp)
            )

            Text(
                text = teamDetailsDriverCardViewState.countryName,
                fontSize = 12.sp,
                color = Color.Gray,
                modifier = Modifier
                    .padding(start = 5.dp, top = 0.dp, end = 5.dp, bottom = 5.dp)
            )
        }
    }
}

@Preview
@Composable
private fun TeamDetailsDriverCardPreview() {
    val driver = F1InfoMock.getDriver()

    TeamDetailsDriverCard(
        teamDetailsDriverCardViewState = TeamDetailsDriverCardViewState(
            id = driver.id,
            name = driver.name,
            imageUrl = driver.imageUrl,
            countryName = driver.countryName
        ),
        modifier = Modifier
            .height(200.dp)
            .width(125.dp)
    )
}