package com.example.lab2android

import androidx.compose.runtime.saveable.rememberSaveable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.lab2android.ui.theme.Lab2androidTheme
import com.example.lab2android.ui.screens.profile.SecondSubScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2androidTheme {
                Lab2App()
            }
        }
    }
}

@PreviewScreenSizes
@Composable
fun Lab2App() {
    var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.PROFILE) }
    val viewModel: MainViewModel = viewModel()

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            AppDestinations.entries.forEach {
                item(
                    icon = { Icon(it.icon, contentDescription = it.label) },
                    label = { Text(it.label) },
                    selected = it == currentDestination,
                    onClick = { currentDestination = it }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                when (currentDestination) {
                    AppDestinations.PROFILE ->
                        ProfileScreen(viewModel, Modifier.padding(innerPadding))

                    AppDestinations.FAVORITES ->
                        FavoritesScreen(viewModel)

                    AppDestinations.SETTINGS ->
                        SettingsScreen(viewModel)
                }
            }
        }
    }
}

enum class AppDestinations(
    val label: String,
    val icon: ImageVector
) {
    PROFILE("Профіль", Icons.Default.AccountBox),
    FAVORITES("Улюблене", Icons.Default.Favorite),
    SETTINGS("Налаштування", Icons.Default.Settings)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: MainViewModel, modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val topBarTitle = when (currentRoute) {
        "main_profile" -> "Профіль"
        "old_layout" -> "Стара розмітка"
        "second_screen" -> "Другий екран"
        else -> "Профіль"
    }

    val canNavigateBack = currentRoute != "main_profile"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(topBarTitle) },
                navigationIcon = {
                    if (canNavigateBack) {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Назад"
                            )
                        }
                    }
                },
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = "main_profile"
            ) {
                composable("main_profile") {
                    ProfileMainSubScreen(
                        viewModel = viewModel,
                        onNavigateToOldLayout = { navController.navigate("old_layout") },
                        onNavigateToSecond = { navController.navigate("second_screen") }
                    )
                }

                composable("old_layout") {
                    OldLayoutScreen(
                        onNext = { navController.navigate("second_screen") }
                    )
                }

                composable("second_screen") {
                    SecondSubScreen(
                        onBack = { navController.popBackStack() }
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewAllScreens() {
    Lab2androidTheme {
        ProfileScreen(MainViewModel())
    }
}