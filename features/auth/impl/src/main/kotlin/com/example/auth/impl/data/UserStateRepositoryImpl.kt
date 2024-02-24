package com.example.auth.impl.data

import android.app.Application
import android.content.Context
import com.example.auth.api.navigation.UserStateRepository

internal const val SP_NAME = "com.example.winterschool"
internal const val AUTH_STATE_PROPERTY = "auth_state"

class UserStateRepositoryImpl(app: Application) : UserStateRepository {

  private val sharedPrefs = app.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)

  override fun isUserLoggedIn(): Boolean {
    return false
//    return sharedPrefs.getBoolean(AUTH_STATE_PROPERTY, false)
  }

  override fun cacheUserAuthState(isAuthorized: Boolean) {
    sharedPrefs.edit().apply {
      putBoolean(AUTH_STATE_PROPERTY, isAuthorized)
    }
      .apply()
  }
}