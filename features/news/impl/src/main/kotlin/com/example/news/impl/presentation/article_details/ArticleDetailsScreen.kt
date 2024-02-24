package com.example.news.impl.presentation.article_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.news.impl.R.drawable
import com.example.news.impl.presentation.news_list.ArticleChip
import com.example.news.impl.presentation.theme.ContrastDarkColor
import com.example.news.impl.presentation.theme.ContrastGrayColor
import com.example.news.impl.presentation.theme.LightGrayColor
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ArticleDetailsScreen(
  articleId: Int,
  navController: NavController,
  viewModel: ArticleDetailsViewModel = koinViewModel { parametersOf(articleId) }
) {
  val article = remember { viewModel.getArticle() }
  val publishDate = remember { viewModel.getDate() }

  Column(
    modifier = Modifier
      .verticalScroll(rememberScrollState())
      .padding(24.dp)
  ) {

    BackButtonWithIcon(
      modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
      navController = navController
    )

    GlideImage(
      imageModel = article::urlToImage,
      modifier = Modifier
        .size(240.dp, 240.dp)
        .clip(RoundedCornerShape(40.dp))
        .align(Alignment.CenterHorizontally),
      imageOptions = ImageOptions(contentScale = ContentScale.Crop, alignment = Alignment.Center),
    )

    ArticleChip(
      modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = 16.dp),
      text = article.source?.name ?: ""
    )

    Text(text = article.content ?: "", color = ContrastDarkColor, fontSize = 20.sp)

    Row(
      modifier = Modifier.padding(top = 20.dp).fillMaxWidth(),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      Text(text = "Author: ${article.author ?: ""}", color = Color.Black)
      Text(text = publishDate ?: "", color = Color.Black)
    }
  }
}

@Composable
fun BackButtonWithIcon(
  modifier: Modifier = Modifier,
  navController: NavController
) {
  IconButton(modifier = modifier, onClick = { navController.popBackStack() }) {
    Icon(painter = painterResource(id = drawable.ic_back_arrow), contentDescription = null)
  }
}