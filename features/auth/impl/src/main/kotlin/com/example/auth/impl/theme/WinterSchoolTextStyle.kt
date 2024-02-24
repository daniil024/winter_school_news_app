package com.example.auth.impl.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object WinterSchoolTextStyle {

    val ScreenHeader1 = TextStyle(
        color = Color.Black,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )

    val ScreenHeader2 = TextStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    val Header20sp = TextStyle(
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    val Header24sp = TextStyle(
        color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    val Hint12spDim = TextStyle(
        color = LightBrownColor,
        fontSize = 12.sp,
        lineHeight = 16.sp
    )

    val Hint14spDim = TextStyle(
        color = LightBrownColor,
        fontSize = 14.sp,
        lineHeight = 18.sp
    )

    val Hint16spDim = TextStyle(
        color = LightBrownColor,
        fontSize = 16.sp,
        lineHeight = 20.sp
    )

    val Hint14spBright = TextStyle(
        color = ContrastDarkColor,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

    val ErrorHint14sp = TextStyle(
        color = ErrorTextColor,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = (0.5).sp
    )

    val TextClarification = TextStyle(
        color = ContrastDarkColor,
        fontSize = 16.sp,
        lineHeight = 22.sp
    )

    val ConfirmationCodeBlockTextPlaceholder = TextStyle(
        color = ContrastGrayColor,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold
    )

    val ConfirmationCodeBlockText = TextStyle(
        color = ContrastDarkColor,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold
    )

    val ConfirmationCodeBlockErrorText = TextStyle(
        color = ErrorTextColor,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold
    )
}