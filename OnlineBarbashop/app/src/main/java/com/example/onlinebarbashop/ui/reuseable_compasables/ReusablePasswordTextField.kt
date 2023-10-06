package com.example.onlinebarbashop.ui.reuseable_compasables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.R
import com.example.onlinebarbashop.ui.theme.myGoldBackground

@Composable
fun ReusablePasswordTextField(
    textFieldValue: String,
    textFieldLabel: String,
    imeAction: ImeAction,
    viewPassword: MutableState<Boolean>,
    supportingText: String,
    textFieldUpdate: (newValue: String) -> Unit,
) {
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = textFieldUpdate,
        singleLine = true,
        label = { Text(textFieldLabel) },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = if (supportingText != "") 4.dp else 0.dp), //For supporting text space below
        shape = RoundedCornerShape(24.dp),
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Lock,
                contentDescription = "Password text field icon"
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(
                    if (!viewPassword.value)
                        R.drawable.fa_eye_regular
                    else
                        R.drawable.fa_eye_slash_regular
                ),
                contentDescription = "Eye icon",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { viewPassword.value = !viewPassword.value }
                    .padding(4.dp)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = imeAction,
        ),
        visualTransformation = if (viewPassword.value)
            VisualTransformation.None
        else
            PasswordVisualTransformation(),
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedBorderColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedLabelColor = Color.Black,
        ),
        isError = supportingText != "",
        supportingText = { Text(supportingText) },
    )
}