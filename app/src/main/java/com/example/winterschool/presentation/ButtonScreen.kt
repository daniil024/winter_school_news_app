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

const val buttonScreenRoute = "button_screen_route"

fun NavController.navigateToButtonScreen() {
  this.navigate(buttonScreenRoute)
}

fun NavGraphBuilder.buttonScreen(navController: NavController) {
  composable(route = buttonScreenRoute) {
    ButtonScreen(navController = navController)
  }
}

@Composable
fun ButtonScreen(navController: NavController) {
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(text = "Button Screen", modifier = Modifier.padding(bottom = 16.dp))
    Button(onClick = { navController.navigateToTextScreen() }) {
      Text(text = "Click me!")
    }
  }
}