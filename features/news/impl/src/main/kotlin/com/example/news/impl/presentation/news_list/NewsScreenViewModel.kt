package com.example.news.impl.presentation.news_list

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.news.impl.model.Article
import com.example.news.impl.model.Articles
import com.google.gson.Gson

class NewsScreenViewModel(
  private val app: Application
): ViewModel() {

  internal fun getNews(): List<Article> {
    val jsonString = app.assets.open("news.json").bufferedReader().use { it.readText() }
    val gson = Gson()
    return gson.fromJson(jsonString, Articles::class.java).articles ?: emptyList()
  }
}