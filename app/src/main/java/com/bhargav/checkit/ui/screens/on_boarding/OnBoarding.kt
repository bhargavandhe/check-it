package com.bhargav.checkit.ui.screens.on_boarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.bhargav.checkit.Routes
import com.bhargav.checkit.ui.components.CheckButton
import com.bhargav.checkit.ui.theme.DarkGreen
import com.bhargav.checkit.ui.theme.PastelGreen

@Composable
fun OnBoarding(navController: NavHostController) {
//    val systemUiController = rememberSystemUiController()
//    systemUiController.setStatusBarColor(color = PastelGreen)

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PastelGreen)
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
                    bottom.linkTo(button.top)
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "CheckIt", style = MaterialTheme.typography.h3, color = DarkGreen)
            Text(
                text = "Manage your daily tasks\nwith CheckIt",
                style = MaterialTheme.typography.body1,
                color = DarkGreen,
                textAlign = TextAlign.Center
            )
        }

        CheckButton(
            text = "Next",
            modifier = Modifier.constrainAs(button) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            },
            onClick = { navController.navigate(Routes.Login.route) },
            color = DarkGreen,
            textColor = Color.White
        )
    }

}
