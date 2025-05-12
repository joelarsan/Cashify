package com.ken.cashify.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ken.cashify.data.UserDatabase
import com.ken.cashify.repository.UserRepository
import com.ken.cashify.screens.about.AboutScreen
import com.ken.cashify.screens.contact.ContactScreen
import com.ken.cashify.screens.expense.ExpenseScreen
import com.ken.cashify.screens.home.HomeScreen
import com.ken.cashify.screens.info.InfoScreen
import com.ken.cashify.screens.profile.ProfileScreen
import com.ken.cashify.screens.splash.SplashScreen
import com.ken.cashify.ui.screens.auth.LoginScreen
import com.ken.cashify.viewmodel.AuthViewModel
import com.ken.cashify.viewmodel.AuthViewModelFactory
import com.ken.harakamall.ui.screens.auth.RegisterScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH
) {
    val context = LocalContext.current

    // Set up Room database, repository, and ViewModel
    val appDatabase = UserDatabase.getDatabase(context)
    val authRepository = UserRepository(appDatabase.userDao())
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(authRepository))

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

        // AUTHENTICATION
        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }
        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }
    }
}
