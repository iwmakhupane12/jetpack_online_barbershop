package com.example.onlinebarbashop.ui.auth

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableButton
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableOutlinedTextField
import com.example.onlinebarbashop.ui.theme.OnlineBarbashopTheme
import com.example.onlinebarbashop.ui.theme.myGoldBackground
import com.example.onlinebarbashop.ui.theme.myGreyBackground

@Composable
fun Registration(onDismiss: () -> Unit) {
    val name = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val phoneNum = remember { mutableStateOf("") }
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val checked = remember { mutableStateOf(false) }
    var verticalPadding = 4.dp

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.myGreyBackground
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ReusableOutlinedTextField(
                textFieldValue = name.value,
                textFieldLabel = "Name",
                leadingIcon = Icons.Rounded.Person,
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                verticalPadding = verticalPadding,
            ) { newValue ->
                name.value = newValue
            }

            ReusableOutlinedTextField(
                textFieldValue = lastName.value,
                textFieldLabel = "Lastname",
                leadingIcon = Icons.Rounded.Person,
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                verticalPadding = verticalPadding,
            ) { newValue ->
                lastName.value = newValue
            }

            ReusableOutlinedTextField(
                textFieldValue = phoneNum.value,
                textFieldLabel = "Phone number",
                leadingIcon = Icons.Rounded.Phone,
                keyboardType = KeyboardType.Phone,
                capitalization = null,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                verticalPadding = verticalPadding,
            ) { newValue ->
                phoneNum.value = newValue
            }

            ReusableOutlinedTextField(
                textFieldValue = emailAddress.value,
                textFieldLabel = "Email address",
                leadingIcon = Icons.Rounded.Email,
                keyboardType = KeyboardType.Email,
                capitalization = null,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                verticalPadding = verticalPadding,
            ) { newValue ->
                emailAddress.value = newValue
            }

            ReusableOutlinedTextField(
                textFieldValue = password.value,
                textFieldLabel = "Password",
                leadingIcon = Icons.Rounded.Lock,
                keyboardType = KeyboardType.Password,
                capitalization = null,
                imeAction = ImeAction.Next,
                visualTransformation = PasswordVisualTransformation(),
                verticalPadding = verticalPadding,
            ) { newValue ->
                password.value = newValue
            }

            ReusableOutlinedTextField(
                textFieldValue = confirmPassword.value,
                textFieldLabel = "Confirm password",
                leadingIcon = Icons.Rounded.Lock,
                keyboardType = KeyboardType.Password,
                capitalization = null,
                imeAction = ImeAction.Done,
                visualTransformation = PasswordVisualTransformation(),
                verticalPadding = verticalPadding,
            ) { newValue ->
                confirmPassword.value = newValue
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                Checkbox(
                    checked = checked.value,
                    onCheckedChange = { isChecked -> checked.value = isChecked },
                    colors = CheckboxDefaults.colors(
                        checkedColor = MaterialTheme.colorScheme.myGoldBackground,
                        checkmarkColor = Color.Black,
                    )
                )

                Text(
                    "I agree to the Terms and Conditions Agreement.",
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            ReusableButton(text = "SIGN UP") {}

            Spacer(modifier = Modifier.size(12.dp))

            Row {
                Text(
                    "Already have an account? ",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                )

                Text(
                    text = " Sign in",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF3865BA),
                    modifier = Modifier.clickable { onDismiss() }
                )
            }

            Divider(thickness = 1.dp, modifier = Modifier.padding(top = 16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    OnlineBarbashopTheme {
        Registration {}
    }
}