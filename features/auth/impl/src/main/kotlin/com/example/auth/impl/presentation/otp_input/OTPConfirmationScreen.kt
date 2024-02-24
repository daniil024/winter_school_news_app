package com.example.auth.impl.presentation.otp_input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.auth.impl.presentation.email_input.BackButtonWithIcon
import com.example.auth.impl.theme.LightGrayColor
import com.example.auth.impl.theme.WinterSchoolTextStyle
import com.example.auth.impl.theme.WinterSchoolTextStyle.ConfirmationCodeBlockTextPlaceholder
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun OTPConfirmationScreen(
  navController: NavController,
  viewModel: OTPConfirmationViewModel = koinViewModel { parametersOf(navController) }
) {

  Column {
    BackButtonWithIcon(
      modifier = Modifier.padding(4.dp, 28.dp, 0.dp, 0.dp),
      navController = navController
    )

    Box(
      modifier = Modifier
        .fillMaxSize()
        .padding(24.dp, 36.dp, 24.dp, 12.dp)
    ) {
      Column(modifier = Modifier.align(Alignment.TopStart)) {
        Text(
          modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 24.dp),
          text = "Confirmation code",
          style = WinterSchoolTextStyle.ScreenHeader1
        )

        Text(
          modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 24.dp),
          text = "Check your email for $OTP_CODE_LENGTH-digits code",
          style = WinterSchoolTextStyle.TextClarification
        )

        OTPCodeBlocks(viewModel)
        ErrorTextHint(viewModel)
      }
    }
  }
}

@Composable
internal fun OTPCodeBlocks(viewModel: OTPConfirmationViewModel) {
  val focusRequester = remember { FocusRequester() }
  val otpCodeTextFieldValue by viewModel.otpCode.collectAsStateWithLifecycle()
  val otpCodeBlockStyle by viewModel.otpCodeBlockStyleFlow.collectAsStateWithLifecycle()

  BasicTextField(
    value = otpCodeTextFieldValue,
    onValueChange = {
      if (otpCodeTextFieldValue.text.length <= OTP_CODE_LENGTH) {
        val updatedTextFieldValue = TextFieldValue(
          text = it.text,
          selection = TextRange(it.text.length)
        )
        viewModel.updateOTPInput(updatedTextFieldValue)
      }
    },
    modifier = Modifier.focusRequester(focusRequester),
    keyboardOptions = KeyboardOptions(
      keyboardType = KeyboardType.NumberPassword,
      imeAction = ImeAction.Done
    ),
    decorationBox = {
      Row(horizontalArrangement = Arrangement.Start) {
        repeat(OTP_CODE_LENGTH) { index ->
          val char = when {
            index >= otpCodeTextFieldValue.text.length -> ""
            else -> otpCodeTextFieldValue.text[index].toString()
          }

          if (otpCodeTextFieldValue.text.isEmpty()) {
            OTPCodeBlock("0", ConfirmationCodeBlockTextPlaceholder, LightGrayColor)
          } else {
            OTPCodeBlock(char, otpCodeBlockStyle.textStyle, otpCodeBlockStyle.blockColor)
          }
          Spacer(modifier = Modifier.width(8.dp))
        }
      }

    }
  )

  LaunchedEffect(Unit) {
    focusRequester.requestFocus()
  }
}

@Composable
internal fun OTPCodeBlock(char: String, textStyle: TextStyle, backgroundColor: Color) {
  Text(
    modifier = Modifier
      .size(50.dp, 60.dp)
      .background(backgroundColor, RoundedCornerShape(8.dp))
      .padding(2.dp),
    text = char,
    style = textStyle,
    textAlign = TextAlign.Center
  )
}

@Composable
internal fun ErrorTextHint(viewModel: OTPConfirmationViewModel) {
  val otpCodeValidityStatus by viewModel.otpCodeValidityStatusFlow.collectAsStateWithLifecycle()

  if (otpCodeValidityStatus == OTPCodeValidityStatus.OTP_CODE_IS_INVALID) {
    Text(
      modifier = Modifier.padding(start = 4.dp, top = 16.dp),
      text = "Invalid code, please try again",
      style = WinterSchoolTextStyle.ErrorHint14sp
    )
  }
}
