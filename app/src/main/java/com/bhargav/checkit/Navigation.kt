package com.bhargav.checkit

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhargav.checkit.ui.screens.home.HomeScreen
import com.bhargav.checkit.ui.screens.login.LoginScreen
import com.bhargav.checkit.ui.screens.on_boarding.OnBoarding
import com.bhargav.checkit.ui.screens.register.RegisterScreen
import com.bhargav.checkit.ui.screens.view.ViewScreen

sealed class Routes(open val route: String) {
    object OnBoarding : Routes("on-boarding")
    object Login : Routes("login")
    object Register : Routes("register")
    object Home : Routes("home")
    object View : Routes("view")
}

@Composable
fun Navigation(navController: NavHostController, paddingValues: PaddingValues) {
    var startDestination = Routes.OnBoarding.route
//    if (FirebaseAuth.getInstance().currentUser != null) startDestination = Routes.Home.route

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        // on-boarding screen
        composable(
            route = Routes.OnBoarding.route,
            content = { OnBoarding(navController = navController) }
        )

        // login screen
        composable(
            route = Routes.Login.route,
            content = { LoginScreen(navController = navController) }
        )

        // register screen
        composable(
            route = Routes.Register.route,
            content = { RegisterScreen(navController = navController) }
        )

        // home screen
        composable(
            route = Routes.Home.route,
            content = { HomeScreen(navController = navController) }
        )

        // view screen
        composable(
            route = Routes.View.route,
            content = { ViewScreen(navController = navController) }
        )
    }
}
