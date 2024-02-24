package com.example.winterschool.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.auth.api.navigation.AuthNavigation
import com.example.news.api.NewsNavigation
import com.example.winterschool.presentation.buttonScreen
import com.example.winterschool.presentation.textScreen
import org.koin.androidx.compose.get

@Composable
fun WinterSchoolNavHost(
  navController: NavHostController,
  authNavigation: AuthNavigation = get(),
  newsNavigation: NewsNavigation = get(),
  startDestination: String = authNavigation.getAuthRoute(),
) {
  NavHost(
    navController = navController,
    startDestination = startDestination,
  ) {

    with(authNavigation) { authScreen(navController) }
    with(authNavigation) { emailInputScreen(navController) }
    with(authNavigation) { otpInputScreen(navController) }

    with(newsNavigation) { newsScreen(navController) }
    with(newsNavigation) { articleDetailsScreen(navController) }

    textScreen(navController)
    buttonScreen(navController)
  }
}