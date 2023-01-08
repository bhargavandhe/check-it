package com.bhargav.checkit.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bhargav.checkit.R

private val workSans_bold = Font(R.font.worksans_bold, FontWeight.Bold)
private val workSans_light = Font(R.font.worksans_light, FontWeight.Light)
private val workSans_regular = Font(R.font.worksans_regular, FontWeight.Normal)
private val workSans_medium = Font(R.font.worksans_medium, FontWeight.Medium)
private val workSans_semiBold = Font(R.font.worksans_semibold, FontWeight.SemiBold)


val workSans = FontFamily(
    fonts = listOf(
        workSans_bold,
        workSans_light,
        workSans_regular,
        workSans_medium,
        workSans_semiBold
    )
)

val delaGothic = FontFamily(fonts = listOf(Font(R.font.dela_gothic_regular)))

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = delaGothic,
        fontWeight = FontWeight.Medium,
        fontSize = 102.sp,
        letterSpacing = (-1.5).sp,
    ),
    h2 = TextStyle(
        fontFamily = delaGothic,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = delaGothic,
        fontWeight = FontWeight.Medium,
        fontSize = 51.sp
    ),
    h4 = TextStyle(
        fontFamily = delaGothic,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        letterSpacing = (0.25).sp
    ),
    h5 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    h6 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = (0.15).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (0.15).sp

    ),
    subtitle2 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = (0.1).sp
    ),
    body1 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = (0.5).sp
    ),
    body2 = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = (0.25).sp
    ),
    button = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = (1.25).sp
    ),
    caption = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = (0.4).sp,
    ),
    overline = TextStyle(
        fontFamily = workSans,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = (1.5).sp,
    )
)
