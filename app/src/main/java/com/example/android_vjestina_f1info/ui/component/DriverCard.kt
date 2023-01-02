package com.example.android_vjestina_f1info.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.android_vjestina_f1info.mock.F1InfoMock

data class DriverCardViewState(
    val name: String,
    val number: Int,
    val imageUrl: String?,
    val points: Int,
    val position: Int
)

@Composable
fun DriverCard(
    driverCardViewState: DriverCardViewState,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp)),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = driverCardViewState.position.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.1F)
                    .padding(5.dp)
            )

            AsyncImage(
                model = driverCardViewState.imageUrl,
                contentDescription = driverCardViewState.name,
                modifier = Modifier
                    .weight(0.2F)
                    .padding(5.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = driverCardViewState.number.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.1F)
                    .padding(5.dp)
            )

            Text(
                text = driverCardViewState.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .weight(0.45F)
                    .padding(5.dp)
            )

            Text(
                text = driverCardViewState.points.toString(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(0.15F)
                    .padding(5.dp)
            )
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun DriverCardPreview() {
    val driver = F1InfoMock.getDriver()
    val driverCardViewState = DriverCardViewState(
        name = driver.name,
        number = driver.number,
        imageUrl = driver.imageUrl,
        points = driver.points,
        position = driver.position
    )

    DriverCard(
        driverCardViewState = driverCardViewState,
        modifier = Modifier
            .width(350.dp)
            .height(60.dp)
    )
}