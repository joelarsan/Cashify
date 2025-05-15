package com.ken.cashify

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ken.cashify.data.UserDatabase
import com.ken.cashify.navigation.*
import com.ken.cashify.repository.UserRepository
import com.ken.cashify.screens.*
import com.ken.cashify.screens.about.AboutScreen
import com.ken.cashify.screens.budget.BudgetScreen
import com.ken.cashify.screens.contact.ContactScreen
import com.ken.cashify.screens.home.HomeScreen
import com.ken.cashify.screens.info.InfoScreen
import com.ken.cashify.screens.profile.ProfileScreen
import com.ken.cashify.screens.settings.SettingsScreen
import com.ken.cashify.screens.splash.SplashScreen
import com.ken.cashify.screens.transaction.TransactionScreen
import com.ken.cashify.ui.screens.auth.LoginScreen
import com.ken.cashify.ui.screens.auth.RegisterScreen
import com.ken.cashify.viewmodel.AuthViewModel
import com.ken.cashify.viewmodel.AuthViewModelFactory
import com.ken.cashify.viewmodel.ExpenseViewModel
import com.ken.cashify.viewmodel.TransactionViewModel
import com.ken.cashify.viewmodel.TransactionViewModelFactory

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_HOME
) {
    val context = LocalContext.current
    val application = context.applicationContext as Application // Get the Application context

    // === USER AUTH VIEWMODEL SETUP ===
    val userDatabase = UserDatabase.getDatabase(context)
    val authRepository = UserRepository(userDatabase.userDao())
    val authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory(authRepository))

    // === EXPENSE VIEWMODEL SETUP ===
    val expenseDatabase = com.ken.cashify.data.ExpenseDatabase.getDatabase(context)
    val expenseDao = expenseDatabase.expenseDao()
    val expenseViewModel: ExpenseViewModel = viewModel(factory = com.ken.cashify.viewmodel.ExpenseViewModelFactory(expenseDao))

    // === TRANSACTION VIEWMODEL SETUP ===
    val transactionViewModel: TransactionViewModel = viewModel(
        factory = TransactionViewModelFactory(application)  // Correct application context usage
    )

    // === NAVIGATION ===
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

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_TRANSACTION) {
            TransactionScreen(navController = navController, viewModel = transactionViewModel)
        }

        composable(ROUT_PROFILE) {
            ProfileScreen(navController)
        }

        composable(ROUT_BUDGET) {
            BudgetScreen(navController)
        }

        composable(ROUT_INFO) {
            InfoScreen(navController)
        }

        composable(ROUT_SETTINGS) {
            SettingsScreen(navController)
        }

        composable(ROUT_CONTACT) {
            ContactScreen(navController)
        }

        // === AUTH SCREENS ===
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
