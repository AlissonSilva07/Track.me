package com.example.trackme.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackme.presentation.ui.theme.BricolageGrotesqueFontFamily
import com.example.trackme.presentation.ui.theme.TrackmeTheme

@Composable
fun HomeHeader(
    userName: String = "Usuário(a)"
) {
    Column(
        modifier = Modifier.padding(start = 16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Boas-vindas,",
            fontFamily = BricolageGrotesqueFontFamily,
            fontSize = 16.sp
        )
        Text(
            text = userName,
            fontFamily = BricolageGrotesqueFontFamily,
            fontSize = 32.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreview() {
    TrackmeTheme {
        HomeHeader()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeHeaderPreviewDark() {
    TrackmeTheme(
        darkTheme = true
    ) {
        HomeHeader()
    }
}