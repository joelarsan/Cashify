
package com.ken.cashify.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ken.cashify.screens.about.AboutScreen
import com.ken.cashify.screens.contact.ContactScreen
import com.ken.cashify.screens.expense.ExpenseScreen
import com.ken.cashify.screens.info.InfoScreen
import com.ken.cashify.screens.profile.ProfileScreen
import com.ken.cashify.screens.splash.SplashScreen
import com.ken.cashify.viewmodel.ProfileViewModel


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_HOME
) {

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }
        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }
        composable(ROUT_EXPENSE) {
            ExpenseScreen(navController)
        }
        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }
        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }
        composable(ROUT_INFO) {
            InfoScreen(navController)
        }
        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }

    }
}