package com.example.news.impl.model

import com.google.gson.annotations.SerializedName

class Articles(
  @SerializedName("articles")
  val articles: List<Article>? = emptyList()
)

class Article(
  @SerializedName("id")
  val id: Int? = null,

  @SerializedName("source")
  val source: Source? = null,

  @SerializedName("author")
  val author: String? = null,

  @SerializedName("title")
  val title: String? = null,

  @SerializedName("description")
  val description: String? = null,

  @SerializedName("url")
  val url: String? = null,

  @SerializedName("urlToImage")
  val urlToImage: String? = null,

  @SerializedName("publishedAt")
  val publishedAt: String? = null,

  @SerializedName("content")
  val content: String? = null
) {

  class Source(
    @SerializedName("name")
    val name: String? = null
  )
}