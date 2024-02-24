package com.example.auth.api.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface AuthNavigation {
  fun navigateToAuthScreen(navController: NavController)
  fun NavGraphBuilder.authScreen(navController: NavController)
  fun getAuthRoute(): String

  fun navigateToEmailInputScreen(navController: NavController)
  fun NavGraphBuilder.emailInputScreen(navController: NavController)
  fun getEmailInputRoute(): String

  fun navigateToOTPInputScreen(navController: NavController)
  fun NavGraphBuilder.otpInputScreen(navController: NavController)
  fun getOTPInputRoute(): String
}