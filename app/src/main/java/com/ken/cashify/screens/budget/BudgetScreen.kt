package com.ken.cashify.screens.budget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ken.harakamall.ui.theme.Azure
import java.nio.file.WatchEvent


@Composable
fun BudgetScreen(navController:NavController){
    Column (modifier = Modifier.fillMaxSize().background(Color.Gray)
        .verticalScroll(rememberScrollState())
    ) {



        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "CREATE A BUDGET",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 20.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))


        //Variables
        var category by remember { mutableStateOf("") }
        var limit by remember { mutableStateOf("") }
        var frequency by remember { mutableStateOf("") }


        //Category
        OutlinedTextField(
            value = category,
            onValueChange = { category= it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Category") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        //End

        Spacer(modifier = Modifier.height(50.dp))


        //Limit
        OutlinedTextField(
            value = limit,
            onValueChange = { limit = it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Warning,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Limit")
             },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )

        //End

        Spacer(modifier = Modifier.height(50.dp))

        //Frequency
        OutlinedTextField(
            value = frequency,
            onValueChange = { frequency = it },
            modifier = Modifier.fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp),
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "",
                    tint = Color.Black
                )
            },
            label = { Text(text = "Frequency") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Gray,
                focusedLabelColor = Azure,
                unfocusedBorderColor = Color.Black

            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        //End

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
            },
            colors = ButtonDefaults.buttonColors(Azure),
            shape = RoundedCornerShape(11.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

        ) {
            Text(text = "Set Budget")
        }






    }




}

@Preview(showBackground = true)
@Composable
fun BudgetScreenPreview() {
    BudgetScreen(rememberNavController())

}
