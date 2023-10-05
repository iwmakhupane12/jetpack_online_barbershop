package com.example.onlinebarbashop.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.R
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableOutlinedTextField
import com.example.onlinebarbashop.ui.theme.OnlineBarbashopTheme
import com.example.onlinebarbashop.ui.theme.myGoldBackground
import com.example.onlinebarbashop.ui.theme.myGreyBackground

@Composable
fun Login() {
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val verticalPadding = 4.dp
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.myGreyBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "WELCOME BACK",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFFF0CA00),
            )

            Text(
                "Login to you your account to get started",
                style = MaterialTheme.typography.bodyMedium,
            )

            Spacer(modifier = Modifier.size(20.dp))

            Card(
                modifier = Modifier.size(128.dp),
                shape = CircleShape,
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Image(
                    painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.size(24.dp))

            ReusableOutlinedTextField(
                emailAddress.value,
                "Email address",
                Icons.Rounded.Person,
                KeyboardType.Email,
                ImeAction.Next,
                VisualTransformation.None,
                verticalPadding
            ) { newValue ->
                emailAddress.value = newValue
            }

            ReusableOutlinedTextField(
                password.value,
                "Password",
                Icons.Rounded.Lock,
                KeyboardType.Password,
                ImeAction.Done,
                PasswordVisualTransformation(),
                verticalPadding
            ) { newValue ->
                password.value = newValue
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = ButtonDefaults.buttonElevation(8.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.myGoldBackground),
                onClick = { /*TODO*/ }) {
                Text(text = "LOGIN", color = Color.Black)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                LowerTextButton("Create new account") {}
                LowerTextButton("Forgot password?") {}
            }

            Divider(thickness = 1.dp)
        }
    }
}

@Composable
fun LowerTextButton(textString: String, onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(
            text = textString,
            color = Color(0xFF3865BA),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    OnlineBarbashopTheme {
        Login()
    }
}