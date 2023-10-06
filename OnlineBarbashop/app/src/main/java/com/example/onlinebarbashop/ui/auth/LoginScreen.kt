package com.example.onlinebarbashop.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableButton
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableOutlinedTextField
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableTextButton
import com.example.onlinebarbashop.ui.theme.OnlineBarbashopTheme
import com.example.onlinebarbashop.ui.theme.myGreyBackground

@Composable
fun Login() {
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    var showCreateAccountSheet by remember { mutableStateOf(false) }
    val verticalPadding = 4.dp

    if (showCreateAccountSheet) {
        BottomSheet { showCreateAccountSheet = false }
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.myGreyBackground
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
                "Sign in to your account to get started",
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
                Icons.Rounded.Email,
                KeyboardType.Email,
                null,
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
                null,
                ImeAction.Done,
                PasswordVisualTransformation(),
                verticalPadding
            ) { newValue ->
                password.value = newValue
            }

            ReusableButton(text = "SIGN IN") {}

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ReusableTextButton("Create new account") {
                    showCreateAccountSheet = !showCreateAccountSheet
                }
                ReusableTextButton("Forgot password?") {}
            }

            Divider(thickness = 1.dp)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
        containerColor = MaterialTheme.colorScheme.myGreyBackground,
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "Fill in your details to get started",
                    style = MaterialTheme.typography.bodyMedium,
                )

                FilledIconButton(
                    onClick = { onDismiss() },
                    shape = CircleShape,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = Color(
                            0xFFD9D9D9
                        )
                    )
                ) {
                    Icon(
                        Icons.Rounded.Close, contentDescription = "Modal drag",
                        tint = Color(0xFF303030),
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }) {
        Registration { onDismiss() }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    OnlineBarbashopTheme {
        Login()
    }
}