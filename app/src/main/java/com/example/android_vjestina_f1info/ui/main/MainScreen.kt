package com.example.android_vjestina_f1info.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.android_vjestina_f1info.R
import com.example.android_vjestina_f1info.navigation.NavigationItem
import com.example.android_vjestina_f1info.navigation.TEAM_ID_KEY
import com.example.android_vjestina_f1info.navigation.TeamDetailsDestination
import com.example.android_vjestina_f1info.ui.driverStandings.DriverStandingsRoute
import com.example.android_vjestina_f1info.ui.home.HomeRoute
import com.example.android_vjestina_f1info.ui.teamDetailsScreen.TeamDetailsRoute
import com.example.android_vjestina_f1info.ui.teamStandings.TeamStandingsRoute
import com.example.android_vjestina_f1info.ui.theme.spacing
import org.koin.androidx.compose.get
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val showBottomBar by remember {
        derivedStateOf {
            when (navBackStackEntry?.destination?.route) {
                TeamDetailsDestination.route -> false
                else -> true
            }
        }
    }

    val showBackIcon = !showBottomBar

    Scaffold(
        topBar = {
            TopBar(
                navigationIcon = {
                    if (showBackIcon) BackIcon(onBackClick = navController::popBackStack)
                }
            )
        },
        bottomBar = {
            if (showBottomBar)
                BottomNavigationBar(
                    destinations = listOf(
                        NavigationItem.HomeDestination,
                        NavigationItem.DriverStandingsDestination,
                        NavigationItem.TeamStandingsDestination
                    ),
                    onNavigateToDestination = {
                        navController.navigate(it.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    currentDestination = navBackStackEntry?.destination
                )
        }
    ) { padding ->
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavigationItem.HomeDestination.route,
                modifier = Modifier.padding(padding)
            ) {
                composable(NavigationItem.HomeDestination.route) {
                    HomeRoute(
                        viewModel = getViewModel(),
                        onNavigateToTeamDetails = {
                            navController.navigate(
                                TeamDetailsDestination.createNavigationRoute(it)
                            )
                        }
                    )
                }

                composable(NavigationItem.TeamStandingsDestination.route) {
                    TeamStandingsRoute(
                        viewModel = getViewModel()
                    )
                }

                composable(NavigationItem.DriverStandingsDestination.route) {
                    DriverStandingsRoute(
                        viewModel = getViewModel()
                    )
                }

                composable(
                    route = TeamDetailsDestination.route,
                    arguments = listOf(navArgument(TEAM_ID_KEY) { type = NavType.IntType }),
                ) {
                    TeamDetailsRoute(
                        viewModel = getViewModel(
                            parameters = {
                                parametersOf(
                                    it.arguments?.getInt(TEAM_ID_KEY)
                                )
                            })
                    )
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .wrapContentHeight()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = R.drawable.f1_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )

            if (navigationIcon != null) {
                navigationIcon()
            }
        }
    }
}

@Composable
private fun BackIcon(
    onBackClick: () -> Unit
) {
    Icon(
        modifier = Modifier
            .padding(8.dp)
            .clickable(onClick = onBackClick)
            .width(12.dp)
            .height(20.dp),
        painter = painterResource(id = R.drawable.back_icon),
        contentDescription = null
    )
}

@Composable
private fun BottomNavigationBar(
    destinations: List<NavigationItem>,
    onNavigateToDestination: (NavigationItem) -> Unit,
    currentDestination: NavDestination?,
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        destinations.forEach { destination ->
            val isSelected = currentDestination?.route == destination.route
            BottomNavigationItem(
                selected = isSelected,
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected)
                                destination.selectedIconId
                            else destination.unselectedIconId
                        ),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = destination.labelId),
                        fontSize = 10.sp,
                        color = Color.Blue
                    )
                },
                onClick = { onNavigateToDestination(destination) })
        }
    }
}