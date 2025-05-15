package com.ken.cashify.screens.transaction

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ken.cashify.viewmodel.TransactionViewModel
import com.ken.cashify.model.Transaction

@Composable
fun TransactionScreen(
    navController: NavController,
    viewModel: TransactionViewModel
) {
    val transactions by viewModel.transactions.collectAsState(initial = emptyList()) // Collect transaction state
    var description by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    // Outer column to handle non-scrolling form fields and static content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(40.dp)
    ) {
        // Header and Input Fields (non-scrolling)
        Text("Add Transaction", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)

        Spacer(modifier = Modifier.height(56.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val amt = amount.toDoubleOrNull()
            if (!description.isBlank() && amt != null) {
                // Call ViewModel method to add transaction
                viewModel.addTransaction(description, amt)
                Log.d("TransactionScreen", "Transaction Added: $description, Amount: $amt")
                description = ""  // Reset after saving
                amount = ""  // Reset after saving
            } else {
                Log.e("TransactionScreen", "Invalid input or empty fields")
            }
        }) {
            Text("Save Transaction")
        }

        Spacer(modifier = Modifier.height(40.dp))

        // LazyColumn starts here for the list of transactions
        Text("Transactions", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)

        Spacer(modifier = Modifier.height(20.dp))

        // LazyColumn for displaying transactions
        LazyColumn {
            items(transactions) { transaction ->
                Text(
                    text = "${transaction.description}: $${transaction.amount}",
                    modifier = Modifier.padding(vertical = 4.dp),
                    color = Color.White
                )
            }
        }
    }
}
