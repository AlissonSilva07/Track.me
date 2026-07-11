package com.example.trackme.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.trackme.presentation.navigation.AppNavigation
import com.example.trackme.presentation.ui.theme.TrackmeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrackmeTheme(
                dynamicColor = false
            ) {
                AppNavigation()
            }
        }
    }
}