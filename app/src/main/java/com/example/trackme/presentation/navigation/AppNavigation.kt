package com.example.trackme.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.trackme.presentation.screens.OnboardingScreen

sealed class Screen() : NavKey {
    data object Main : Screen()
    data object Onboarding : Screen()

    data object Home : Screen()
    data object Profile : Screen()
}

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val globalBackStack = remember { mutableStateListOf<Screen>(Screen.Onboarding) }
    NavDisplay(
        backStack = globalBackStack,
        onBack = { globalBackStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Screen.Onboarding> {
                OnboardingScreen(onNavigateToMain = {
                    globalBackStack.remove(Screen.Onboarding)
                    globalBackStack.add(Screen.Main)
                })
            }
            entry<Screen.Main> {
                MainNavigation(globalBackStack = globalBackStack)
            }
        }
    )
}