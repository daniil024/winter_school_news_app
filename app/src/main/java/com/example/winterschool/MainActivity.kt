package com.example.winterschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.auth.api.navigation.AuthNavigation
import com.example.auth.api.navigation.UserStateRepository
import com.example.news.api.NewsNavigation
import com.example.winterschool.navigation.WinterSchoolNavHost
import com.example.winterschool.theme.WinterSchoolTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

  private val userStateRepository: UserStateRepository by inject<UserStateRepository>()
  private val newsNavigation: NewsNavigation by inject<NewsNavigation>()
  private val authNavigation: AuthNavigation by inject<AuthNavigation>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController: NavHostController = rememberNavController()
      val startDestination =
        if (userStateRepository.isUserLoggedIn()) newsNavigation.getNewsRoute() else authNavigation.getAuthRoute()
      WinterSchoolNavHost(navController = navController, startDestination = startDestination)
    }
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = "Hello $name!",
      modifier = modifier
    )
    Button(onClick = {}) {
      Text(text = "Tap me!")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  WinterSchoolTheme {
    Greeting("Android")
  }
}