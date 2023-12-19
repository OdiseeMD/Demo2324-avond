package be.odisee.wolf.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import be.odisee.wolf.R

val WolfFont = FontFamily(
    Font(R.font.wolf)
)

val ExoFont = FontFamily(
    Font(R.font.exo)
)

// Set of Material typography styles to start with
val Typography = Typography(

    titleLarge = TextStyle(
        fontFamily = WolfFont,
        fontSize = 22.sp,
        platformStyle = PlatformTextStyle(includeFontPadding = false)
    ),

    labelMedium = TextStyle(
        fontFamily = ExoFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.W700
    )
)