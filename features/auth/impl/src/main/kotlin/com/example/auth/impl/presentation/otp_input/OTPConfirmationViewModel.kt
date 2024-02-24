package com.example.auth.impl.presentation.otp_input

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.auth.api.navigation.UserStateRepository
import com.example.auth.impl.model.OTPCodeBlockStyle
import com.example.auth.impl.model.OTPCodeBlockStyle.Companion.ERROR_STYLE
import com.example.auth.impl.model.OTPCodeBlockStyle.Companion.WITHOUT_ERROR_STYLE
import com.example.auth.impl.presentation.otp_input.OTPCodeValidityStatus.NOT_VERIFIED
import com.example.auth.impl.presentation.otp_input.OTPCodeValidityStatus.OTP_CODE_IS_INVALID
import com.example.auth.impl.presentation.otp_input.OTPCodeValidityStatus.OTP_CODE_IS_VALID
import com.example.news.api.NewsNavigation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

internal const val OTP_CODE_LENGTH = 5
private val INITIAL_OTP_CODE_TEXT_FIELD_VALUE = TextFieldValue(text = "", selection = TextRange(0))

class OTPConfirmationViewModel(
  private val navController: NavController,
  private val newsNavigation: NewsNavigation,
  private val userStateRepository: UserStateRepository,
) : ViewModel() {

  private val _otpCode = MutableStateFlow(INITIAL_OTP_CODE_TEXT_FIELD_VALUE)
  private val _otpCodeValidityStatusFlow = MutableStateFlow(NOT_VERIFIED)
  private val _otpCodeBlockStyleFlow = MutableStateFlow(WITHOUT_ERROR_STYLE)

  internal val otpCode: StateFlow<TextFieldValue> get() = _otpCode
  internal val otpCodeValidityStatusFlow: StateFlow<OTPCodeValidityStatus> get() = _otpCodeValidityStatusFlow
  internal val otpCodeBlockStyleFlow: StateFlow<OTPCodeBlockStyle> get() = _otpCodeBlockStyleFlow


  init {
    observeOTPCodeBlockStyle()
  }

  private fun observeOTPCodeBlockStyle() {
    viewModelScope.launch(Dispatchers.IO) {
      otpCodeValidityStatusFlow.map {
        when (it) {
          OTP_CODE_IS_VALID, NOT_VERIFIED -> WITHOUT_ERROR_STYLE
          OTP_CODE_IS_INVALID -> ERROR_STYLE
        }
      }
        .collect(_otpCodeBlockStyleFlow::tryEmit)
    }
  }

  internal fun updateOTPInput(otpCodeTextFieldValue: TextFieldValue) {
    _otpCode.tryEmit(otpCodeTextFieldValue)

    val otp = _otpCode.value
    if (otp.text.length == OTP_CODE_LENGTH) {
      handleUserOTPInput(otp.text)
    } else if (_otpCodeValidityStatusFlow.value != NOT_VERIFIED) {
      _otpCodeValidityStatusFlow.tryEmit(NOT_VERIFIED)
    }
  }

  private fun handleUserOTPInput(otp: String) {
    // send request to backend and check if OTP is valid

    if (otp == "12345") {
      _otpCodeValidityStatusFlow.tryEmit(OTP_CODE_IS_VALID)
      newsNavigation.navigateToNewsScreen(navController)
      userStateRepository.cacheUserAuthState(true)
    } else {
      _otpCodeValidityStatusFlow.tryEmit(OTP_CODE_IS_INVALID)
    }
  }
}

enum class OTPCodeValidityStatus {
  OTP_CODE_IS_VALID, OTP_CODE_IS_INVALID, NOT_VERIFIED
}