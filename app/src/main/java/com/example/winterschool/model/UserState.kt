package com.example.winterschool.model

data class UserState(
  val email: String,
  val isLoggedIn: Boolean
) {

  companion object {
    val EMPTY = UserState("", false)
  }
}
