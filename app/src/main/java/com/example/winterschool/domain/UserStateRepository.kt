package com.example.winterschool.domain

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserStateRepository {

  private val _isUserLoggedInFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)

  val isUserLoggedInFlow: StateFlow<Boolean> get() = _isUserLoggedInFlow

  val isUserLoggedIn: Boolean get() = _isUserLoggedInFlow.value

  fun updateUserAuthenticationState(isUserLoggedIn: Boolean) {
    _isUserLoggedInFlow.value = isUserLoggedIn
  }
}