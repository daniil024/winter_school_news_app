package com.example.auth.impl.presentation.email_input

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

internal class EmailInputViewModel : ViewModel() {

  private val _userEmailFlow: MutableStateFlow<String> = MutableStateFlow("")

  internal val userEmailFlow: StateFlow<String> get() = _userEmailFlow

  internal fun updateUserEmail(userEmail: String) {
    _userEmailFlow.tryEmit(userEmail)
  }

  internal fun onNextScreenButtonClicked(action: () -> Unit) {
    processUserEmailInput()
    action()
  }

  private fun processUserEmailInput() {
    // send user email to backend
  }
}