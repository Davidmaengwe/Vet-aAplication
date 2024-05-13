package com.example.wazitoecommerce.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wazitoecommerce.ui.theme.screens.appointment.AppointmentScreen
import com.example.wazitoecommerce.ui.theme.screens.home.HomeScreen
import com.example.wazitoecommerce.ui.theme.screens.login.LoginScreen
import com.example.wazitoecommerce.ui.theme.screens.medrecords.MedicalRecordsScreen
import com.example.wazitoecommerce.ui.theme.screens.notification.NotificationScreen
import com.example.wazitoecommerce.ui.theme.screens.pet.PetProfileScreen
import com.example.wazitoecommerce.ui.theme.screens.search.MainScreen
import com.example.wazitoecommerce.ui.theme.screens.setting.SettingScreen
import com.example.wazitoecommerce.ui.theme.screens.signup.SignupScreen
import com.example.wazitoecommerce.ui.theme.screens.vet.VetProfileScreen
import com.example.wazitoecommerce.ui.theme.screens.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController:NavHostController = rememberNavController(),
    startDestination:String = HOME_URL,
){
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier){
        composable(LOGIN_URL){
            LoginScreen(navController = navController)
        }
        composable(SIGNUP_URL){
            SignupScreen(navController = navController)
        }
        composable(HOME_URL,
            enterTransition =  {
                return@composable scaleIn(
                    animationSpec = tween(220, delayMillis = 90),
                ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
            },
            exitTransition =  {
                return@composable scaleOut(
                    animationSpec = tween(
                        durationMillis = 220,
                        delayMillis = 90
                    ),
                ) + fadeOut(tween(delayMillis = 90))
            }

        ){
            HomeScreen(navController = navController)
        }
        composable(NOTIFICATION_URL,
            enterTransition =  {
                return@composable scaleIn(
                    animationSpec = tween(220, delayMillis = 90),
                ) + fadeIn(animationSpec = tween(220, delayMillis = 90))
            }
        ){
            NotificationScreen(navController = navController)
        }
        composable(SETTING_URL){
            SettingScreen(navController = navController)
        }
        composable(VETPROFILE_URL,enterTransition = {
            return@composable expandIn(tween(900))
        }, exitTransition = {
            return@composable shrinkOut(tween(900))
        }, popExitTransition = { return@composable shrinkOut() }
        ){
            VetProfileScreen(navController = navController)
        }
        composable(PETPROFILE_URL){
            PetProfileScreen(navController = navController)
        }
        composable(APPOINTMENT_URL,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Left, tween(900)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(900)
                )
            },
        ){
            AppointmentScreen(navController = navController)
        }
        composable(MEDICAL_URL,
            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(700)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(700)
                )
            },
        ){
            MedicalRecordsScreen(navController = navController)
        }
        composable(SEARCH_URL,

            enterTransition = {
                return@composable slideIntoContainer(
                    AnimatedContentTransitionScope.SlideDirection.Start, tween(900)
                )
            },
            popExitTransition = {
                return@composable slideOutOfContainer(
                    AnimatedContentTransitionScope.SlideDirection.End, tween(900)
                )
            },){
            MainScreen(navController = navController)
        }
        composable(WELCOME_URL){
            WelcomeScreen(navController = navController)
        }
        composable(APPOINT_URL){

        }

    }
}