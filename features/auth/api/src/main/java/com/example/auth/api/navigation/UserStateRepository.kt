package com.example.auth.api.navigation

interface UserStateRepository {

  fun isUserLoggedIn(): Boolean

  fun cacheUserAuthState(isAuthorized: Boolean)
}