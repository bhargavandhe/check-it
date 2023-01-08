package com.bhargav.checkit.ui.screens.login

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
import com.bhargav.checkit.ui.theme.DarkPurple
import com.bhargav.checkit.ui.theme.PastelPurple
import com.bhargav.checkit.ui.theme.workSans

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PastelPurple)
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
                text = "Enter your email address to continue",
                style = MaterialTheme.typography.h4.copy(fontFamily = workSans)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = "We'll create a new account for you,\nif no existing account is found!",
                style = MaterialTheme.typography.body1
            )

            Spacer(modifier = Modifier.height(36.dp))

            CheckOutlinedTextField(label = "Email", value = email, onValueChanged = { email = it })
            CheckOutlinedTextField(
                label = "Password",
                value = password,
                onValueChanged = { password = it })
        }

        CheckButton(
            text = "Next",
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            onClick = { navController.navigate(Routes.Register.route) },
            color = DarkPurple,
            textColor = Color.White
        )
    }
}
