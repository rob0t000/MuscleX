package com.example.musclex.navigation




import ExerciseScreen
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musclex.HomeScreen
import com.example.musclex.LoginScreen
import com.example.musclex.SplashScreen


@Composable
fun MainNavController() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screens.Splash.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300),
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300),
            )
        },

        ) {

        composable(Screens.Login.route) {
            LoginScreen(navController = navHostController)
        }

        composable(Screens.Splash.route) {
            SplashScreen(navController = navHostController)

        }
        composable(Screens.Home.route) {
            HomeScreen(navController = navHostController)

        }
        composable(Screens.Exercise.route) {
            ExerciseScreen(navController = navHostController)

        }






    }
}
