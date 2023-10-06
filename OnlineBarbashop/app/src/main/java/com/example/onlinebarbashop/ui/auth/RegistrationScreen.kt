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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableButton
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusableOutlinedTextField
import com.example.onlinebarbashop.ui.reuseable_compasables.ReusablePasswordTextField
import com.example.onlinebarbashop.ui.theme.OnlineBarbashopTheme
import com.example.onlinebarbashop.ui.theme.myGoldBackground
import com.example.onlinebarbashop.ui.theme.myGreyBackground
import com.example.onlinebarbashop.ui.util.emailValidation
import com.example.onlinebarbashop.ui.util.namesValidation
import com.example.onlinebarbashop.ui.util.passwordMatch
import com.example.onlinebarbashop.ui.util.passwordValidation
import com.example.onlinebarbashop.ui.util.phoneNumValidation

@Composable
fun Registration(onDismiss: () -> Unit) {
    val name = remember { mutableStateOf("") }
    val phoneNum = remember { mutableStateOf("") }
    val emailAddress = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }
    val checked = remember { mutableStateOf(false) }
    val viewPassword = remember { mutableStateOf(false) }
    val viewConfirmPassword = remember { mutableStateOf(false) }
    val passwordMismatch = remember { mutableStateOf(false) }

    val namesValidation = remember { mutableStateOf("") }
    val phoneNumValidation = remember { mutableStateOf("") }
    val emailValidation = remember { mutableStateOf("") }
    val passwordValidation = remember { mutableStateOf("") }
    val confirmPasswordValidation = remember { mutableStateOf("") }

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
                textFieldLabel = "Names",
                leadingIcon = Icons.Rounded.Person,
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                namesValidation.value,
            ) { newValue ->
                name.value = newValue
                namesValidation.value = namesValidation(names = name.value)
            }

            ReusableOutlinedTextField(
                textFieldValue = phoneNum.value,
                textFieldLabel = "Phone number",
                leadingIcon = Icons.Rounded.Phone,
                keyboardType = KeyboardType.Phone,
                capitalization = null,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                phoneNumValidation.value,
            ) { newValue ->
                phoneNum.value = newValue
                phoneNumValidation.value = phoneNumValidation(phoneNum = phoneNum.value)
            }

            ReusableOutlinedTextField(
                textFieldValue = emailAddress.value,
                textFieldLabel = "Email address",
                leadingIcon = Icons.Rounded.Email,
                keyboardType = KeyboardType.Email,
                capitalization = null,
                imeAction = ImeAction.Next,
                visualTransformation = VisualTransformation.None,
                emailValidation.value,
            ) { newValue ->
                emailAddress.value = newValue
                emailValidation.value = emailValidation(emailAddress = emailAddress.value)
            }

            ReusablePasswordTextField(
                textFieldValue = password.value,
                textFieldLabel = "New password",
                imeAction = ImeAction.Next,
                viewPassword = viewPassword,
                supportingText = passwordValidation.value,
            ) { newValue ->
                password.value = newValue
                passwordValidation.value = passwordMatch(confirmPassword.value, password.value)
            }

            ReusablePasswordTextField(
                textFieldValue = confirmPassword.value,
                textFieldLabel = "Confirm password",
                imeAction = ImeAction.Done,
                viewPassword = viewConfirmPassword,
                supportingText = confirmPasswordValidation.value,
            ) { newValue ->
                confirmPassword.value = newValue
                confirmPasswordValidation.value =
                    passwordMatch(confirmPassword.value, password.value)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
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

            ReusableButton(text = "SIGN UP") {
                namesValidation.value = namesValidation(names = name.value)
                phoneNumValidation.value = phoneNumValidation(phoneNum = phoneNum.value)
                emailValidation.value = emailValidation(emailAddress = emailAddress.value)
                passwordValidation.value = passwordValidation(password = password.value)
                confirmPasswordValidation.value =
                    passwordValidation(password = confirmPassword.value)
            }

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