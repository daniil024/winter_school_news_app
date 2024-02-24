package com.example.news.impl.di

import com.example.news.api.NewsNavigation
import com.example.news.impl.navigation.NewsNavigationImpl
import com.example.news.impl.presentation.article_details.ArticleDetailsViewModel
import com.example.news.impl.presentation.news_list.NewsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

val newsModule = module {
  factoryOf(::NewsNavigationImpl) bind NewsNavigation::class

  viewModelOf(::NewsScreenViewModel)
  viewModel { params -> ArticleDetailsViewModel(articleId = params.get(), get()) }
}