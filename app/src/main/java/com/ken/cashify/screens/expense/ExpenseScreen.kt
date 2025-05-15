package com.ken.cashify.screens.expense

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ken.cashify.model.Expense
import com.ken.cashify.viewmodel.ExpenseViewModel

@Composable
fun ExpenseScreen(
    navController: NavController,
    expenseViewModel: ExpenseViewModel  // Accepting the ViewModel
) {
    // Variables for user input
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()
        .background(Color.Black)
        .padding(40.dp)
        .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "ADD EXPENSE",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Category Input
        OutlinedTextField(
            value = category,
            onValueChange = { category = it },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Category",
                    tint = Color.White
                )
            },
            label = { Text(text = "Category") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedBorderColor = Color.White
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Amount Input
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Amount",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Amount") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Date Input
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Date",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Date") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Description Input
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Description",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Description") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Color.Black,
                unfocusedBorderColor = Color.Black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(40.dp))

        // Save Button
        Button(
            onClick = {
                // Create an Expense object to insert into the database
                val expense = Expense(
                    description = description,
                    amount = amount.toDoubleOrNull() ?: 0.0
                )
                expenseViewModel.insertExpense(expense)  // Calling the ViewModel function to insert the expense
            },
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(11.dp),
            modifier = Modifier.fillMaxWidth().padding(20.dp)
        ) {
            Text(text = "Save New Expense")
        }
    }
}
