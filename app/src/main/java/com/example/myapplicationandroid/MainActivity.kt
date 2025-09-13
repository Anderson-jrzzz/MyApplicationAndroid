package com.example.myapplicationandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationandroid.ui.theme.MyApplicationAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFF64DE64)
            ) {
                GreetingCard()
            }

        }
    }
}

@Composable
fun GreetingCard() {
    var name by remember { mutableStateOf("") }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(75.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id=R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier
                .size(100.dp)
                .background(Color(0xFF2A602A)),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Nombre
        Text(
            text = "Anderson Ramos",
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
        // Título
        Text(
            text = "Android Developer Extraordinaire",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF006400), // Verde oscuro
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(150.dp))

        // Información de contacto
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ContactInfoRow(
                icon = Icons.Default.Phone,
                contactText = "+51 985 - 785 - 596"
            )
            ContactInfoRow(
                icon = Icons.Default.Share,
                contactText = "@AndroidDev"
            )
            ContactInfoRow(
                icon = Icons.Default.Email,
                contactText = "anderson.ramos@android.com"
            )
        }

    }
    
}

@Composable
fun ContactInfoRow(icon: androidx.compose.ui.graphics.vector.ImageVector, contactText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,

        )
        Text(
            text = contactText,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
        GreetingCard()
}