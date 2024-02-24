package com.example.auth.impl.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.auth.impl.R
import com.example.auth.impl.navigation.navigateToEmailInputScreen
import com.example.news.api.NewsNavigation
import org.koin.androidx.compose.get

@Composable
internal fun AuthScreen(
  navController: NavController,
  newsNavigation: NewsNavigation = get()
) {
  Box {
    Image(
      painterResource(id = R.drawable.news_brown),
      contentDescription = null,
      contentScale = ContentScale.Crop,
      modifier = Modifier.fillMaxSize(),
      alignment = Alignment.Center
    )

    Column(
      modifier = Modifier
        .align(Alignment.BottomCenter)
        .padding(20.dp, 0.dp, 20.dp, 36.dp),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      AuthButton(
        modifier = Modifier.padding(0.dp, 8.dp),
        text = "Authorize",
        backgroundColor = Color.White,
        textColor = Color.Black,
        borderColor = Color.White,
        onClick = navController::navigateToEmailInputScreen
      )

      AuthButton(
        modifier = Modifier.padding(0.dp, 8.dp),
        text = "Open news",
        backgroundColor = Color.Transparent,
        textColor = Color.White,
        borderColor = Color.White,
        onClick = { newsNavigation.navigateToNewsScreen(navController) }
      )
    }
  }
}

@Composable
internal fun AuthButton(
  modifier: Modifier = Modifier,
  text: String,
  textColor: Color,
  backgroundColor: Color,
  borderColor: Color,
  onClick: () -> Unit,
) {
  Button(
    modifier = modifier
      .fillMaxWidth()
      .height(54.dp),
    elevation = null,
    shape = RoundedCornerShape(52.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
    border = BorderStroke(1.dp, borderColor),
    onClick = onClick
  ) {
    Text(text = text, color = textColor, fontSize = 18.sp)
  }
}
