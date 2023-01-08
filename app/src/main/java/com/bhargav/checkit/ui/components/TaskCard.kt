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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bhargav.checkit.R
import com.bhargav.checkit.model.People
import com.bhargav.checkit.ui.theme.Yellow
import kotlinx.coroutines.launch

@Composable
fun TaskCard(
    modifier: Modifier = Modifier,
    color: Color,
    title: String,
    subtitle: String,
    people: List<People>,
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

    Column(
        modifier = modifier
            .scale(scale.value)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(size = 32.dp))
            .background(color = color)
            .clickable(
                interactionSource = interactionSource,
                indication = LocalIndication.current,
                onClick = { onClick() }
            )
            .padding(vertical = 24.dp, horizontal = 32.dp),
    ) {
        Text(text = title, style = MaterialTheme.typography.h4, color = Color.Black)
        Spacer(modifier = Modifier.height(2.dp))
        Text(text = subtitle, style = MaterialTheme.typography.body2, color = Color.Black)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            LazyRow(horizontalArrangement = Arrangement.spacedBy((-8).dp)) {
                items(items = people) {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(shape = CircleShape)
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.image)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.ic_baseline_person_24),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.clip(CircleShape)
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.Black)
                    .clickable { },
                contentAlignment = Alignment.Center,
                content = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "add",
                        tint = Color.White
                    )
                }
            )
        }
    }
}

@Preview
@Composable
fun TaskCardPreview() {
    TaskCard(color = Yellow, title = "Today", subtitle = "3 active tasks", people = listOf())
}
