package com.joaquindev.medlink.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joaquindev.medlink.views.CreateTreatmentView
import com.joaquindev.medlink.views.HomeView
import com.joaquindev.medlink.views.LoginView
import com.joaquindev.medlink.views.ReadTtreatmentView
import com.joaquindev.medlink.views.RecoverPasswordView
import com.joaquindev.medlink.views.RegisterView
import com.joaquindev.medlink.views.SettingsView
import com.joaquindev.medlink.views.UpdateTreatmentView
import com.joaquindev.medlink.views.WelcomeView

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavManager() {
    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "WelcomeView") {
    NavHost(navController = navController, startDestination = "ReadTreatment") {
        composable("Welcome") {
            WelcomeView(navController)
        }
        composable("Login") {
            LoginView(navController)
        }
        composable("Register") {
            RegisterView(navController)
        }
        composable("RecoverPassword") {
            RecoverPasswordView(navController)
        }
        composable("Home") {
            HomeView(navController)
        }
        composable("Settings") {
            SettingsView(navController)
        }
        composable("ReadTreatment") {
            ReadTtreatmentView(navController)
        }
        composable("CreateTreatment") {
            CreateTreatmentView(navController)
        }
        composable("UpdateTreatment") {
            UpdateTreatmentView(navController)
        }


//        composable("TestComponents") {
//            TestComponents()
//        }

    }

}