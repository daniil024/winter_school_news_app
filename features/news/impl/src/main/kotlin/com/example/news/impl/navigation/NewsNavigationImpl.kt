package com.example.news.impl.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.news.api.NewsNavigation
import com.example.news.impl.presentation.article_details.ArticleDetailsScreen
import com.example.news.impl.presentation.news_list.NewsScreen

const val newsScreenRoute = "news_screen_route"

internal const val articleIdentifier = "article_id"
const val articleDetailsBaseNavigationRoute = "article_details_screen_route"
const val articleDetailsScreenRoute = "$articleDetailsBaseNavigationRoute/{$articleIdentifier}"

class NewsNavigationImpl : NewsNavigation {
  override fun navigateToNewsScreen(navController: NavController) =
    navController.navigateToNewsScreen()

  override fun NavGraphBuilder.newsScreen(navController: NavController) {
    composable(route = newsScreenRoute) {
      NewsScreen(navController)
    }
  }

  override fun getNewsRoute(): String = newsScreenRoute

  override fun navigateToArticleDetailsScreen(navController: NavController, articleId: Int) =
    navController.navigateToArticleDetailsScreen(articleId)

  override fun NavGraphBuilder.articleDetailsScreen(navController: NavController) {
    composable(
      route = articleDetailsScreenRoute,
      arguments = listOf(navArgument(articleIdentifier) { type = NavType.IntType })
    ) { backStackEntry ->
      ArticleDetailsScreen(
        articleId = backStackEntry.arguments?.getInt(articleIdentifier) ?: -1,
        navController = navController
      )
    }
  }

  override fun getArticleDetailsRoute(): String = articleDetailsScreenRoute
}

fun NavController.navigateToNewsScreen() {
  this.navigate(newsScreenRoute)
}

fun NavController.navigateToArticleDetailsScreen(articleId: Int) {
  this.navigate("$articleDetailsBaseNavigationRoute/$articleId")
}