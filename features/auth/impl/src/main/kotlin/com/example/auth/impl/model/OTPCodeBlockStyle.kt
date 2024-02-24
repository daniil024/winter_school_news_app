package com.example.auth.impl.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.auth.impl.theme.ErrorBackgroundColor
import com.example.auth.impl.theme.LightGrayColor
import com.example.auth.impl.theme.WinterSchoolTextStyle

data class OTPCodeBlockStyle(
    val textStyle: TextStyle,
    val blockColor: Color
) {

    companion object {
        val ERROR_STYLE = OTPCodeBlockStyle(
            textStyle = WinterSchoolTextStyle.ConfirmationCodeBlockErrorText,
            blockColor = ErrorBackgroundColor
        )

        val WITHOUT_ERROR_STYLE = OTPCodeBlockStyle(
            textStyle = WinterSchoolTextStyle.ConfirmationCodeBlockText,
            blockColor = LightGrayColor
        )
    }
}