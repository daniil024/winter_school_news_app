package com.example.auth.impl.di

import com.example.auth.api.navigation.AuthNavigation
import com.example.auth.api.navigation.UserStateRepository
import com.example.auth.impl.data.UserStateRepositoryImpl
import com.example.auth.impl.navigation.AuthNavigationImpl
import com.example.auth.impl.presentation.email_input.EmailInputViewModel
import com.example.auth.impl.presentation.otp_input.OTPConfirmationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val authModule = module {
  factoryOf(::AuthNavigationImpl) bind AuthNavigation::class
  factoryOf(::UserStateRepositoryImpl) bind UserStateRepository::class

  viewModelOf(::EmailInputViewModel)
  viewModel { params -> OTPConfirmationViewModel(navController = params.get(), get(), get()) }
}