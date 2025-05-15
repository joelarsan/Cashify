package com.ken.cashify


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ken.cashify.data.ExpenseDatabase
import com.ken.cashify.viewmodel.ExpenseViewModel
import com.ken.cashify.viewmodel.ExpenseViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ExpenseDatabase and ExpenseDao
        val db = ExpenseDatabase.getDatabase(applicationContext)
        val dao = db.expenseDao()

        // Create ViewModel factory and ViewModel
        val factory = ExpenseViewModelFactory(dao)
        val expenseViewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)

        // Set the content with NavHost
        setContent {
    AppNavHost()
        }
    }
}


