package com.example.onlinebarbashop.ui.reuseable_compasables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.onlinebarbashop.ui.theme.myGoldBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReusableOutlinedTextField(
    textFieldValue: String,
    textFieldLabel: String,
    leadingIcon: ImageVector,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    visualTransformation: VisualTransformation,
    verticalPadding: Dp,
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
            .padding(vertical = verticalPadding),
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
        ),
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            cursorColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedBorderColor = MaterialTheme.colorScheme.myGoldBackground,
            focusedLabelColor = Color.Black,
        ),
    )
}