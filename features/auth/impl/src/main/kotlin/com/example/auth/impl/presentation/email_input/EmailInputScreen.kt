package com.example.auth.impl.presentation.email_input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.auth.impl.R.drawable
import com.example.auth.impl.navigation.navigateToOTPInputScreen
import com.example.auth.impl.theme.ContrastDarkColor
import com.example.auth.impl.theme.ContrastGrayColor
import com.example.auth.impl.theme.LightGrayColor
import com.example.auth.impl.theme.WinterSchoolTextStyle
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun EmailInputScreen(
  navController: NavController,
  viewModel: EmailInputViewModel = koinViewModel()
) {
  val userEmailText by viewModel.userEmailFlow.collectAsStateWithLifecycle()

  Column {
    BackButtonWithIcon(
      modifier = Modifier.padding(4.dp, 28.dp, 0.dp, 0.dp),
      navController = navController
    )

    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(20.dp, 36.dp, 20.dp, 28.dp)
    ) {
      Column(modifier = Modifier.align(Alignment.TopStart)) {
        Text(
          modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 24.dp),
          text = "Authorization",
          style = WinterSchoolTextStyle.ScreenHeader1
        )
        Text(
          modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 8.dp),
          text = "Email",
          style = WinterSchoolTextStyle.Hint14spDim
        )
        FullWidthRoundedTextField(
          text = userEmailText,
          onValueChange = { email -> viewModel.updateUserEmail(email) },
          placeholderText = "Input email",
          keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        Text(
          modifier = Modifier.padding(4.dp, 4.dp, 0.dp, 0.dp),
          text = "We will send an email with a confirmation code",
          style = WinterSchoolTextStyle.Hint16spDim
        )
      }

      ContinueButton(
        modifier = Modifier.align(Alignment.BottomCenter),
        text = "Next",
        backgroundColor = ContrastDarkColor,
        textColor = LightGrayColor,
        borderColor = ContrastDarkColor
      ) {
        viewModel.onNextScreenButtonClicked { navController.navigateToOTPInputScreen() }
      }
    }
  }
}

@Composable
internal fun ContinueButton(
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

@Composable
fun BackButtonWithIcon(
  modifier: Modifier = Modifier,
  navController: NavController
) {
  IconButton(modifier = modifier, onClick = { navController.popBackStack() }) {
    Icon(painter = painterResource(id = drawable.ic_back_arrow), contentDescription = null)
  }
}

@Composable
fun FullWidthRoundedTextField(
  modifier: Modifier = Modifier,
  text: String = "",
  onValueChange: (String) -> Unit = { },
  placeholderText: String = "",
  keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
  TextField(
    modifier = modifier
      .fillMaxWidth()
      .height(56.dp),
    value = text,
    onValueChange = { onValueChange(it) },
    placeholder = { Text(text = placeholderText) },
    shape = RoundedCornerShape(16.dp),
    keyboardOptions = keyboardOptions,
    colors = TextFieldDefaults.textFieldColors(
      textColor = ContrastDarkColor,
      backgroundColor = LightGrayColor,
      placeholderColor = ContrastGrayColor,
      cursorColor = ContrastDarkColor,
      focusedIndicatorColor = Color.Transparent,
      unfocusedIndicatorColor = Color.Transparent
    ),
    singleLine = true
  )
}
