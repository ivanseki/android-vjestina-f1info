package com.example.android_vjestina_f1info.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.android_vjestina_f1info.R

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    isFavourite: Boolean,
    onClick: () -> Unit,
) {
    Image(
        painter = painterResource(id = if (isFavourite) R.drawable.ic_favorite_filled else R.drawable.ic_favorite_outlined),
        contentDescription = null,
        modifier = modifier
            .clickable { onClick() }
            .wrapContentSize()
    )
}

@Preview(showBackground = true)
@Composable
private fun FavoriteButtonPreview() {
    FavoriteButton(
        modifier = Modifier
            .padding(2.dp)
            .size(30.dp),
        isFavourite = true,
        onClick = { }
    )
}