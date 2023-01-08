package com.bhargav.checkit.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun CheckButton(
    text: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    color: Color = MaterialTheme.colors.primary,
    enabled: Boolean = true,
    shape: Shape = MaterialTheme.shapes.large,
    onClick: () -> Unit = { }
) {
    val scale = remember { Animatable(initialValue = 1f) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    LaunchedEffect(isPressed) {
        launch {
            when {
                isPressed -> scale.animateTo(
                    targetValue = 0.95f,
                    animationSpec = tween(delayMillis = 0)
                )
                else -> scale.animateTo(
                    targetValue = 1f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
            }
        }
    }

    Button(
        modifier = modifier
            .scale(scale.value)
            .fillMaxWidth()
            .height(64.dp),
        interactionSource = interactionSource,
        enabled = enabled,
        shape = shape,
        elevation = null,
        colors = ButtonDefaults.buttonColors(backgroundColor = color),
        onClick = { onClick.invoke() },
        content = {
            Text(
                text = text.uppercase(),
                style = MaterialTheme.typography.button,
                color = textColor
            )
        }
    )
}
