package com.example.trackme.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trackme.presentation.ui.theme.BricolageGrotesqueFontFamily
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import com.example.trackme.presentation.ui.theme.VibrantBlue

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onNavigateToMain: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(VibrantBlue)
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Spacer(Modifier.weight(0.2f))
            Text(
                text = "Construa hábitos mais saudáveis",
                fontFamily = BricolageGrotesqueFontFamily,
                fontSize = 44.sp,
                textAlign = TextAlign.Center,
                color = Color.White
            )
            Spacer(Modifier.weight(1f))
            Button(
                onClick = onNavigateToMain,
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                contentPadding = PaddingValues(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black
                )
            ) {
                Text(
                    text = "Continuar",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    TrackmeTheme {
        OnboardingScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreviewDark() {
    TrackmeTheme(
        darkTheme = true
    ) {
        OnboardingScreen()
    }
}