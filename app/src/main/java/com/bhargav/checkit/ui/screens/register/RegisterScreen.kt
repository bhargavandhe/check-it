package com.bhargav.checkit.ui.screens.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.bhargav.checkit.Routes
import com.bhargav.checkit.ui.components.CheckButton
import com.bhargav.checkit.ui.components.CheckOutlinedTextField
import com.bhargav.checkit.ui.theme.Blue
import com.bhargav.checkit.ui.theme.DarkBlue
import com.bhargav.checkit.ui.theme.PastelBlue
import com.bhargav.checkit.ui.theme.workSans

@Composable
fun RegisterScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PastelBlue)
            .padding(32.dp)
    ) {
        val (layout, button) = createRefs()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(layout) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
        ) {
            Text(text = "CheckIt", style = MaterialTheme.typography.h4)

            Spacer(modifier = Modifier.height(36.dp))

            Text(
                text = "Let's get to know you",
                style = MaterialTheme.typography.h4.copy(fontFamily = workSans)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "Enter your name",
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(36.dp))

            CheckOutlinedTextField(label = "Name", value = name, onValueChanged = { name = it })
        }

        CheckButton(
            text = "Finish",
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            onClick = { navController.navigate(Routes.Home.route) },
            color = Blue,
            textColor = Color.White
        )
    }
}
