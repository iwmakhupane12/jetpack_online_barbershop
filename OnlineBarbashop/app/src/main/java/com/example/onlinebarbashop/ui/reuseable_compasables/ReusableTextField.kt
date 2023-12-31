package com.example.onlinebarbashop.ui.reuseable_compasables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.ui.theme.myGoldBackground

@Composable
fun ReusableOutlinedTextField(
    textFieldValue: String,
    textFieldLabel: String,
    leadingIcon: ImageVector,
    keyboardType: KeyboardType,
    capitalization: KeyboardCapitalization?,
    imeAction: ImeAction,
    visualTransformation: VisualTransformation,
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
            .padding(vertical = if (supportingText != "") 4.dp else 0.dp),
        shape = RoundedCornerShape(24.dp),
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "Text field icon"
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
            capitalization = capitalization ?: KeyboardCapitalization.None,
        ),
        visualTransformation = visualTransformation,
        colors = OutlinedTextFieldDefaults.colors(
            cursorColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedBorderColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedLabelColor = Color.Black,
        ),
        isError = supportingText != "",
        supportingText = {Text(supportingText)}
    )
}