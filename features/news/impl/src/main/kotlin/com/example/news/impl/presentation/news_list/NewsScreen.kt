package com.example.news.impl.presentation.news_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.news.impl.model.Article
import com.example.news.impl.navigation.navigateToArticleDetailsScreen
import com.example.news.impl.presentation.theme.ContrastDarkColor
import com.example.news.impl.presentation.theme.ContrastGrayColor
import com.example.news.impl.presentation.theme.GrayBorderColor
import com.example.news.impl.presentation.theme.LightBrownColor
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.getViewModel

@Composable
fun NewsScreen(
  navController: NavController,
  viewModel: NewsScreenViewModel = getViewModel()
) {
  LazyColumn(modifier = Modifier.padding(14.dp, 20.dp, 14.dp, 0.dp)) {
    items(viewModel.getNews()) {
      ArticlePreview(it, navController)
    }
  }
}

@Composable
fun ArticlePreview(article: Article, navController: NavController) {
  Row(
    modifier = Modifier
      .padding(top = 12.dp, bottom = 14.dp)
      .clickable { article.id?.let { navController.navigateToArticleDetailsScreen(articleId = it) } }
  ) {
    GlideImage(
      imageModel = { article.urlToImage },
      modifier = Modifier
        .size(110.dp, 110.dp)
        .clip(RoundedCornerShape(20.dp)),
      imageOptions = ImageOptions(contentScale = ContentScale.Crop, alignment = Alignment.Center),
      failure = {
        Box(
          modifier = Modifier
            .size(110.dp, 110.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(ContrastGrayColor)
        ) {
          Text(modifier = Modifier.align(Alignment.Center), text = "No image")
        }
      }
    )
    Column(Modifier.padding(start = 12.dp)) {
      Text(
        text = article.title ?: "",
        fontSize = 20.sp,
        color = ContrastDarkColor,
        fontWeight = FontWeight.Bold,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
      )
      Text(
        text = article.description ?: "",
        modifier = Modifier.padding(top = 4.dp),
        fontSize = 14.sp,
        color = LightBrownColor,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
      )
      if (article.source?.name != null) {
        ArticleChip(text = article.source.name)
      }
    }
  }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
internal fun ArticleChip(
  modifier: Modifier = Modifier,
  text: String
) {
  Chip(
    modifier = modifier,
    onClick = {},
    border = BorderStroke(1.dp, GrayBorderColor),
    shape = RoundedCornerShape(10.dp),
    colors = ChipDefaults.outlinedChipColors()
  ) {
    Text(
      text = text,
      fontSize = 12.sp,
      color = LightBrownColor
    )
  }
}
