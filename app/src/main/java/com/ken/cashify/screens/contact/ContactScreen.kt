package com.ken.cashify.screens.contact

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ken.cashify.R


@Composable
fun ContactScreen(navController: NavController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Profile Image Placeholder
        Image(
            painter = painterResource(id = R.drawable.person), // Replace with your drawable
            contentDescription = "Profile",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("John Doe", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Customer Support", fontSize = 16.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(40.dp))

        // Contact Buttons
        Button(
            onClick = {
                val callIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+254 746 172 669"))
                context.startActivity(callIntent)
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
        ) {
            Text("Call", color = Color.Black)
        }

        Button(
            onClick = {
                val smsIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:+254 746 172 669"))
                context.startActivity(smsIntent)
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
        ) {
            Text("Message", color = Color.Black)
        }

        Button(
            onClick = {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:joelarsan50@gmail.com")
                    putExtra(Intent.EXTRA_SUBJECT, "Customer Inquiry")
                }
                context.startActivity(emailIntent)
            },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336))
        ) {
            Text("Email", color = Color.Black)
        }
    }
}
