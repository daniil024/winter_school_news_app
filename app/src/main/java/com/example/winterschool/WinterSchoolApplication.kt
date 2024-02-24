package com.example.winterschool

import android.app.Application
import com.example.auth.impl.di.authModule
import com.example.news.impl.di.newsModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class WinterSchoolApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    startKoin {
      androidLogger(Level.DEBUG)
      androidContext(this@WinterSchoolApplication)
      modules(listOf(authModule, newsModule))
    }
  }
}