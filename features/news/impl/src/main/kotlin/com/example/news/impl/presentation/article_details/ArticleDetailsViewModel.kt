package com.example.news.impl.presentation.article_details

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.news.impl.model.Article
import com.example.news.impl.model.Articles
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.Locale

class ArticleDetailsViewModel(
  private val articleId: Int,
  private val app: Application
) : ViewModel() {

  private val article: Article

  init {
    val jsonString = app.assets.open("news.json").bufferedReader().use { it.readText() }
    val news = Gson().fromJson(jsonString, Articles::class.java).articles ?: emptyList()
    article = news.first { it.id == articleId }
  }

  fun getArticle(): Article {
    return article
  }

  fun getDate(): String? {
    val text = article.publishedAt ?: return null

    val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US)
    val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.US)
    return formatter.format(parser.parse(text))

//    val text = article.publishedAt ?: return null
//    val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
//    return LocalDateTime.parse(text, pattern).toString()
  }
}