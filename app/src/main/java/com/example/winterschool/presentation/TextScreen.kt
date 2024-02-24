package com.example.winterschool.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val textScreenRoute = "text_screen_route"

fun NavController.navigateToTextScreen() {
  this.navigate(textScreenRoute)
}

fun NavGraphBuilder.textScreen(navController: NavController) {
  composable(route = textScreenRoute) {
    TextScreen(navController = navController)
  }
}

@Composable
fun TextScreen(navController: NavController) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Text Screen", modifier = Modifier.padding(bottom = 16.dp))
    Button(onClick = { navController.navigateToButtonScreen() }) {
      Text(text = "Back to Button Screen")
    }
  }
}
