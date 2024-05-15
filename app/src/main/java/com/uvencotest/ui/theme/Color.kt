package com.uvencotest.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val background = Color(0xFF000000)
val cardGradient = Brush.linearGradient(
    colors = listOf(Color(0xFF19110E), Color(0xFF100909))
)
val priceGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF1D1412),
        Color(0xFF160E0C),
        Color(0xFF231917)
    ),
    start = Offset(0f, 0f),
    end = Offset(1f, 0.44f)
)
val labelColor = Color(0xFFC4A79B)
val priceColor = Color(0xFFF77416)
val valueColor = Color(0xFF514541)
val logoText = Color(0xFF5A4036)
val topBarTextColor = Color(0xFF896C61)
val TopBarBottomBorderColor = Color(0xFF261A18)
val inputBackground = Color(0xFF150E0C)
val inputTextColor = Color(0xFFFFF2ED)
val switchBackground = Color(0xFFFF9900)
val buttonTextColor = Color(0xFFFFFAF7)