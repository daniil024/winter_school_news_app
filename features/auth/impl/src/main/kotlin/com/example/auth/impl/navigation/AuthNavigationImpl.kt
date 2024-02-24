package com.example.auth.impl.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.auth.api.navigation.AuthNavigation
import com.example.auth.impl.presentation.AuthScreen
import com.example.auth.impl.presentation.email_input.EmailInputScreen
import com.example.auth.impl.presentation.otp_input.OTPConfirmationScreen

const val authScreenRoute = "auth_screen_route"
const val emailInputScreenRoute = "email_input_screen_route"
const val otpInputScreenRoute = "otp_input_screen_route"

class AuthNavigationImpl : AuthNavigation {
  override fun navigateToAuthScreen(navController: NavController) =
    navController.navigateToAuthScreen()

  override fun NavGraphBuilder.authScreen(navController: NavController) {
    composable(route = authScreenRoute) {
      AuthScreen(navController = navController)
    }
  }

  override fun getAuthRoute(): String = authScreenRoute

  override fun navigateToEmailInputScreen(navController: NavController) =
    navController.navigateToEmailInputScreen()

  override fun NavGraphBuilder.emailInputScreen(navController: NavController) {
    composable(route = emailInputScreenRoute) {
      EmailInputScreen(navController = navController)
    }
  }

  override fun getEmailInputRoute(): String = emailInputScreenRoute

  override fun navigateToOTPInputScreen(navController: NavController) =
    navController.navigateToOTPInputScreen()

  override fun NavGraphBuilder.otpInputScreen(navController: NavController) {
    composable(route = otpInputScreenRoute) {
      OTPConfirmationScreen(navController = navController)
    }
  }

  override fun getOTPInputRoute(): String = otpInputScreenRoute
}

internal fun NavController.navigateToAuthScreen() {
  this.navigate(authScreenRoute)
}

internal fun NavController.navigateToEmailInputScreen() {
  this.navigate(emailInputScreenRoute)
}

internal fun NavController.navigateToOTPInputScreen() {
  this.navigate(otpInputScreenRoute)
}