package com.bhargav.checkit.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


// CheckOutlinedTextField
@Composable
fun CheckOutlinedTextField(
    label: String,
    modifier: Modifier = Modifier,
    value: String = "",
    placeholder: String = "",
    enabled: Boolean = true,
    singleLine: Boolean = true,
    errorText: String = "",
    trailingIcon: @Composable () -> Unit = { },
    keyboardType: KeyboardType = KeyboardType.Text,
    gutterBottom: Dp = 16.dp,
    onValueChanged: (String) -> Unit = {},
) {
    var textFieldValue = value
    Column {
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(72.dp),
            value = textFieldValue,
            enabled = enabled,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
            onValueChange = {
                textFieldValue = it
                onValueChanged(it)
            },
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedLabelColor = Color.Black.copy(alpha = 0.7f),
                unfocusedLabelColor = Color.Black.copy(alpha = 0.7f),
                errorLabelColor = Color.Red,
                disabledLabelColor = Color.Gray,

                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black,
                errorBorderColor = Color.Red,
                disabledBorderColor = Color.Gray,

                textColor = Color.Black.copy(alpha = 0.7f),
                cursorColor = Color.Black,
            ),
            trailingIcon = { trailingIcon() },
            singleLine = singleLine,
            visualTransformation = if (keyboardType == KeyboardType.Password) PasswordVisualTransformation() else VisualTransformation.None
        )
        AnimatedVisibility(errorText != "") {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = errorText,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.error
            )
        }
    }
    Spacer(modifier = Modifier.height(gutterBottom))
}
