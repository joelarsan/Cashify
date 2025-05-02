package com.ken.cashify.screens.expense

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ken.harakamall.ui.theme.Azure

@Composable
fun ExpenseScreen(navController:NavController){

    Column (modifier = Modifier.fillMaxSize().background(Color.Gray)
        .verticalScroll(rememberScrollState())

    ) {


        Spacer(modifier = Modifier.height(10.dp))


        Text(
            text = "ADD EXPENSE",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,


        )
        Spacer(modifier = Modifier.height(40.dp))

        
        //Variables
        var fullname by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }

        //Fullname
        OutlinedTextField(
            value = fullname,
            onValueChange = { fullname = it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Fullname") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        //End

        Spacer(modifier = Modifier.height(100.dp))


        //Date
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Date") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //End
        Spacer(modifier = Modifier.height(100.dp))



        //Description
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Description") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Black,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //End

        Spacer(modifier = Modifier.height(100.dp))





        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray),
            shape = RoundedCornerShape(11.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Save Transaction")
        }

    }



}

@Preview(showBackground = true)
@Composable
fun ExpenseScreenPreview() {
    ExpenseScreen(rememberNavController())

}
