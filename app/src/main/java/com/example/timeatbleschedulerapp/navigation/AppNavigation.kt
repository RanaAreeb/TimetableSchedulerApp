package com.example.timeatbleschedulerapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.timeatbleschedulerapp.ui.screens.onboarding.OnboardingScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "onboarding"
    ) {
        composable("onboarding") {
            OnboardingScreen {
                navController.navigate("auth") {
                    popUpTo("onboarding") { inclusive = true }
                }
            }
        }
        
        composable("auth") {
            // Auth screen will be handled by AuthActivity
        }
    }
}
