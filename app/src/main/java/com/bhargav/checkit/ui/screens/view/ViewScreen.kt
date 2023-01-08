package com.bhargav.checkit.ui.screens.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bhargav.checkit.ui.components.CheckButton
import com.bhargav.checkit.ui.components.Task
import com.bhargav.checkit.ui.theme.Yellow
import kotlinx.coroutines.launch

@Composable
fun ViewScreen(navController: NavController) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Yellow)
            .padding(24.dp)
    ) {
        val (header, content, footer) = createRefs()

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.Black)
                    .clickable { navController.popBackStack() },
                contentAlignment = Alignment.Center,
                content = {
                    Icon(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = "notifications",
                        tint = Color.White
                    )
                }
            )

            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(shape = CircleShape)
                    .background(color = Color.Black)
                    .clickable { },
                contentAlignment = Alignment.Center,
                content = {
                    Icon(
                        imageVector = Icons.Rounded.MoreVert,
                        contentDescription = "notifications",
                        tint = Color.White
                    )
                }
            )
        }

        Column(
            modifier = Modifier.constrainAs(content) {
                top.linkTo(anchor = header.bottom, margin = 12.dp)
                start.linkTo(parent.start)
            },
        ) {
            Text(text = "Today", color = Color.Black, style = MaterialTheme.typography.h4)
            Text(
                text = "I need to complete all these tasks",
                color = Color.Black,
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "1 of 4 tasks completed",
                style = MaterialTheme.typography.h6,
                color = Color.Black
            )

            Tasks()
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CheckButton(
                text = "Delete",
                modifier = Modifier.weight(1f),
                color = Color.Red,
                shape = CircleShape
            )
            CheckButton(
                text = "Save",
                modifier = Modifier.weight(1f),
                color = Color.Black,
                shape = CircleShape
            )
        }
    }
}

@Composable
fun Tasks() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(4) {
            var value by remember { mutableStateOf(false) }
            Task(title = "Breakfast", isCompleted = value, onCheck = { value = it })
        }
    }
}
