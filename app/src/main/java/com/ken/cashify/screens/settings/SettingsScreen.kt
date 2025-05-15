package com.ken.cashify.screens.settings

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ken.cashify.navigation.ROUT_BUDGET
import com.ken.cashify.navigation.ROUT_CONTACT
import com.ken.cashify.navigation.ROUT_PROFILE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController:NavController){
    Column (modifier = Modifier.fillMaxSize().background(Color.Black)
        .verticalScroll(rememberScrollState())
        .padding(40.dp)

    ){

        //Box
        Box (){
            //Card
            Card ( modifier = Modifier.fillMaxWidth().height(500.dp)
                .paint(painter = painterResource(R.drawable.alert_dark_frame), contentScale = ContentScale.FillBounds),

            shape = RoundedCornerShape(bottomStart = 60.dp, bottomEnd = 60.dp),
                colors = CardDefaults.cardColors(Color.White)
            ){
                TopAppBar(
                    title = { Text(text ="SETTINGS" ) },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },


                )

            }
            //End of Card

            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(380.dp)
                    .align(alignment = Alignment.BottomCenter)
                    .padding(start = 20.dp, end = 20.dp)
                    .offset(y = 90.dp)

            ){
                //Add Card Contents
                Spacer(modifier = Modifier.height(100.dp))

                //PROFILE BUTTON
                Button(
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    shape = RoundedCornerShape(11.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

                ){
                    Text(text = "PROFILE")
                }

                Spacer(modifier = Modifier.height(20.dp))

                //PROFILE BUTTON


                //EXPORT DATA BUTTON
                Button(
                    onClick = {
                        ROUT_PROFILE

                    },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = RoundedCornerShape(11.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

                ){
                    Text(text = "YOUR DATA")
                }

                Spacer(modifier = Modifier.height(20.dp))

                //EXPORT DATA BUTTON


                //SET A NEW BUDGET
                Button(
                    onClick = {
                        ROUT_BUDGET
                    },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = RoundedCornerShape(11.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

                ){
                    Text(text = "SET A NEW BUDGET")
                }

                Spacer(modifier = Modifier.height(20.dp))

                //SET A NEW BUDGET

                //PRIVACY POLICY
                Button(
                    onClick = {
                        ROUT_CONTACT

                    },
                    colors = ButtonDefaults.buttonColors(Color.Gray),
                    shape = RoundedCornerShape(11.dp),
                    modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp)

                ){
                    Text(text = "PRIVACY POLICY")
                }

                Spacer(modifier = Modifier.height(20.dp))

                //PRIVACY POLICY



            }


        }
        //End of Box






    }

}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen(rememberNavController())

}
