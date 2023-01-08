package com.bhargav.checkit.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bhargav.checkit.ui.theme.DarkBlue
import com.bhargav.checkit.ui.theme.Yellow
import kotlinx.coroutines.launch


@Composable
fun Task(
    isCompleted: Boolean = false,
    title: String,
    onCheck: (Boolean) -> Unit = { }
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

    var value = isCompleted
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .scale(scale.value)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = Color.Black.copy(alpha = 0.1f))
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = {
                    value = !value
                    onCheck(value)
                },
            )
            .padding(top = 4.dp, bottom = 4.dp, start = 8.dp, end = 16.dp)
    ) {
        val (radio, label, anchor) = createRefs()
        RadioButton(
            modifier = Modifier.constrainAs(radio) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            selected = value,
            onClick = {
                value = !value
                onCheck(value)
            },
            colors = RadioButtonDefaults.colors(
                selectedColor = DarkBlue
            )
        )

        Text(
            text = title,
            style = when {
                isCompleted -> MaterialTheme.typography.body1.copy(textDecoration = TextDecoration.LineThrough)
                else -> MaterialTheme.typography.body1
            },
            color = Color.Black,
            modifier = Modifier.constrainAs(label) {
                start.linkTo(radio.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )

        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = "reorder",
            tint = Color.Black,
            modifier = Modifier.constrainAs(anchor) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}
