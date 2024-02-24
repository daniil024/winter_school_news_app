package com.example.news.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface NewsNavigation {
  fun navigateToNewsScreen(navController: NavController)
  fun NavGraphBuilder.newsScreen(navController: NavController)
  fun getNewsRoute(): String

  fun navigateToArticleDetailsScreen(navController: NavController, articleId: Int)
  fun NavGraphBuilder.articleDetailsScreen(navController: NavController)
  fun getArticleDetailsRoute(): String
}