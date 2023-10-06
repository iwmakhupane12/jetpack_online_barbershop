package com.example.onlinebarbashop.ui.reuseable_compasables

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ReusableTextButton(textString: String, onClick: () -> Unit){
    TextButton(onClick = { onClick() }) {
        Text(
            text = textString,
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFF3865BA),
        )
    }
}