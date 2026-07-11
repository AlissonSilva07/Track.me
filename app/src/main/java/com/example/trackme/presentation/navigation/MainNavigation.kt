package com.example.trackme.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import com.example.trackme.presentation.screens.HomeScreen

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    globalBackStack: SnapshotStateList<Screen>,
) {
    val localBackStack = remember { mutableStateListOf<Screen>(Screen.Home) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { /* Your Bottom Navigation items would go here updating localBackStack */ }
    ) { innerPadding ->
        NavDisplay(
            backStack = localBackStack,
            onBack = {
                if (localBackStack.size > 1) {
                    localBackStack.removeLastOrNull()
                } else {
                    globalBackStack.removeLastOrNull()
                }
            },
            entryProvider = entryProvider {
                entry<Screen.Home> {
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding),
                        backStack = localBackStack
                    )
                }
            }
        )
    }
}