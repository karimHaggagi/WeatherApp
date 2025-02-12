package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.ui.theme.backgroundDark
import com.example.ui.theme.backgroundDarkHighContrast
import com.example.ui.theme.backgroundDarkMediumContrast
import com.example.ui.theme.backgroundLight
import com.example.ui.theme.backgroundLightHighContrast
import com.example.ui.theme.backgroundLightMediumContrast
import com.example.ui.theme.errorContainerDark
import com.example.ui.theme.errorContainerDarkHighContrast
import com.example.ui.theme.errorContainerDarkMediumContrast
import com.example.ui.theme.errorContainerLight
import com.example.ui.theme.errorContainerLightHighContrast
import com.example.ui.theme.errorContainerLightMediumContrast
import com.example.ui.theme.errorDark
import com.example.ui.theme.errorDarkHighContrast
import com.example.ui.theme.errorDarkMediumContrast
import com.example.ui.theme.errorLight
import com.example.ui.theme.errorLightHighContrast
import com.example.ui.theme.errorLightMediumContrast
import com.example.ui.theme.inverseOnSurfaceDark
import com.example.ui.theme.inverseOnSurfaceDarkHighContrast
import com.example.ui.theme.inverseOnSurfaceDarkMediumContrast
import com.example.ui.theme.inverseOnSurfaceLight
import com.example.ui.theme.inverseOnSurfaceLightHighContrast
import com.example.ui.theme.inverseOnSurfaceLightMediumContrast
import com.example.ui.theme.inversePrimaryDark
import com.example.ui.theme.inversePrimaryDarkHighContrast
import com.example.ui.theme.inversePrimaryDarkMediumContrast
import com.example.ui.theme.inversePrimaryLight
import com.example.ui.theme.inversePrimaryLightHighContrast
import com.example.ui.theme.inversePrimaryLightMediumContrast
import com.example.ui.theme.inverseSurfaceDark
import com.example.ui.theme.inverseSurfaceDarkHighContrast
import com.example.ui.theme.inverseSurfaceDarkMediumContrast
import com.example.ui.theme.inverseSurfaceLight
import com.example.ui.theme.inverseSurfaceLightHighContrast
import com.example.ui.theme.inverseSurfaceLightMediumContrast
import com.example.ui.theme.onBackgroundDark
import com.example.ui.theme.onBackgroundDarkHighContrast
import com.example.ui.theme.onBackgroundDarkMediumContrast
import com.example.ui.theme.onBackgroundLight
import com.example.ui.theme.onBackgroundLightHighContrast
import com.example.ui.theme.onBackgroundLightMediumContrast
import com.example.ui.theme.onErrorContainerDark
import com.example.ui.theme.onErrorContainerDarkHighContrast
import com.example.ui.theme.onErrorContainerDarkMediumContrast
import com.example.ui.theme.onErrorContainerLight
import com.example.ui.theme.onErrorContainerLightHighContrast
import com.example.ui.theme.onErrorContainerLightMediumContrast
import com.example.ui.theme.onErrorDark
import com.example.ui.theme.onErrorDarkHighContrast
import com.example.ui.theme.onErrorDarkMediumContrast
import com.example.ui.theme.onErrorLight
import com.example.ui.theme.onErrorLightHighContrast
import com.example.ui.theme.onErrorLightMediumContrast
import com.example.ui.theme.onPrimaryContainerDark
import com.example.ui.theme.onPrimaryContainerDarkHighContrast
import com.example.ui.theme.onPrimaryContainerDarkMediumContrast
import com.example.ui.theme.onPrimaryContainerLight
import com.example.ui.theme.onPrimaryContainerLightHighContrast
import com.example.ui.theme.onPrimaryContainerLightMediumContrast
import com.example.ui.theme.onPrimaryDark
import com.example.ui.theme.onPrimaryDarkHighContrast
import com.example.ui.theme.onPrimaryDarkMediumContrast
import com.example.ui.theme.onPrimaryLight
import com.example.ui.theme.onPrimaryLightHighContrast
import com.example.ui.theme.onPrimaryLightMediumContrast
import com.example.ui.theme.onSecondaryContainerDark
import com.example.ui.theme.onSecondaryContainerDarkHighContrast
import com.example.ui.theme.onSecondaryContainerDarkMediumContrast
import com.example.ui.theme.onSecondaryContainerLight
import com.example.ui.theme.onSecondaryContainerLightHighContrast
import com.example.ui.theme.onSecondaryContainerLightMediumContrast
import com.example.ui.theme.onSecondaryDark
import com.example.ui.theme.onSecondaryDarkHighContrast
import com.example.ui.theme.onSecondaryDarkMediumContrast
import com.example.ui.theme.onSecondaryLight
import com.example.ui.theme.onSecondaryLightHighContrast
import com.example.ui.theme.onSecondaryLightMediumContrast
import com.example.ui.theme.onSurfaceDark
import com.example.ui.theme.onSurfaceDarkHighContrast
import com.example.ui.theme.onSurfaceDarkMediumContrast
import com.example.ui.theme.onSurfaceLight
import com.example.ui.theme.onSurfaceLightHighContrast
import com.example.ui.theme.onSurfaceLightMediumContrast
import com.example.ui.theme.onSurfaceVariantDark
import com.example.ui.theme.onSurfaceVariantDarkHighContrast
import com.example.ui.theme.onSurfaceVariantDarkMediumContrast
import com.example.ui.theme.onSurfaceVariantLight
import com.example.ui.theme.onSurfaceVariantLightHighContrast
import com.example.ui.theme.onSurfaceVariantLightMediumContrast
import com.example.ui.theme.onTertiaryContainerDark
import com.example.ui.theme.onTertiaryContainerDarkHighContrast
import com.example.ui.theme.onTertiaryContainerDarkMediumContrast
import com.example.ui.theme.onTertiaryContainerLight
import com.example.ui.theme.onTertiaryContainerLightHighContrast
import com.example.ui.theme.onTertiaryContainerLightMediumContrast
import com.example.ui.theme.onTertiaryDark
import com.example.ui.theme.onTertiaryDarkHighContrast
import com.example.ui.theme.onTertiaryDarkMediumContrast
import com.example.ui.theme.onTertiaryLight
import com.example.ui.theme.onTertiaryLightHighContrast
import com.example.ui.theme.onTertiaryLightMediumContrast
import com.example.ui.theme.outlineDark
import com.example.ui.theme.outlineDarkHighContrast
import com.example.ui.theme.outlineDarkMediumContrast
import com.example.ui.theme.outlineLight
import com.example.ui.theme.outlineLightHighContrast
import com.example.ui.theme.outlineLightMediumContrast
import com.example.ui.theme.outlineVariantDark
import com.example.ui.theme.outlineVariantDarkHighContrast
import com.example.ui.theme.outlineVariantDarkMediumContrast
import com.example.ui.theme.outlineVariantLight
import com.example.ui.theme.outlineVariantLightHighContrast
import com.example.ui.theme.outlineVariantLightMediumContrast
import com.example.ui.theme.primaryContainerDark
import com.example.ui.theme.primaryContainerDarkHighContrast
import com.example.ui.theme.primaryContainerDarkMediumContrast
import com.example.ui.theme.primaryContainerLight
import com.example.ui.theme.primaryContainerLightHighContrast
import com.example.ui.theme.primaryContainerLightMediumContrast
import com.example.ui.theme.primaryDark
import com.example.ui.theme.primaryDarkHighContrast
import com.example.ui.theme.primaryDarkMediumContrast
import com.example.ui.theme.primaryLight
import com.example.ui.theme.primaryLightHighContrast
import com.example.ui.theme.primaryLightMediumContrast
import com.example.ui.theme.scrimDark
import com.example.ui.theme.scrimDarkHighContrast
import com.example.ui.theme.scrimDarkMediumContrast
import com.example.ui.theme.scrimLight
import com.example.ui.theme.scrimLightHighContrast
import com.example.ui.theme.scrimLightMediumContrast
import com.example.ui.theme.secondaryContainerDark
import com.example.ui.theme.secondaryContainerDarkHighContrast
import com.example.ui.theme.secondaryContainerDarkMediumContrast
import com.example.ui.theme.secondaryContainerLight
import com.example.ui.theme.secondaryContainerLightHighContrast
import com.example.ui.theme.secondaryContainerLightMediumContrast
import com.example.ui.theme.secondaryDark
import com.example.ui.theme.secondaryDarkHighContrast
import com.example.ui.theme.secondaryDarkMediumContrast
import com.example.ui.theme.secondaryLight
import com.example.ui.theme.secondaryLightHighContrast
import com.example.ui.theme.secondaryLightMediumContrast
import com.example.ui.theme.surfaceBrightDark
import com.example.ui.theme.surfaceBrightDarkHighContrast
import com.example.ui.theme.surfaceBrightDarkMediumContrast
import com.example.ui.theme.surfaceBrightLight
import com.example.ui.theme.surfaceBrightLightHighContrast
import com.example.ui.theme.surfaceBrightLightMediumContrast
import com.example.ui.theme.surfaceContainerDark
import com.example.ui.theme.surfaceContainerDarkHighContrast
import com.example.ui.theme.surfaceContainerDarkMediumContrast
import com.example.ui.theme.surfaceContainerHighDark
import com.example.ui.theme.surfaceContainerHighDarkHighContrast
import com.example.ui.theme.surfaceContainerHighDarkMediumContrast
import com.example.ui.theme.surfaceContainerHighLight
import com.example.ui.theme.surfaceContainerHighLightHighContrast
import com.example.ui.theme.surfaceContainerHighLightMediumContrast
import com.example.ui.theme.surfaceContainerHighestDark
import com.example.ui.theme.surfaceContainerHighestDarkHighContrast
import com.example.ui.theme.surfaceContainerHighestDarkMediumContrast
import com.example.ui.theme.surfaceContainerHighestLight
import com.example.ui.theme.surfaceContainerHighestLightHighContrast
import com.example.ui.theme.surfaceContainerHighestLightMediumContrast
import com.example.ui.theme.surfaceContainerLight
import com.example.ui.theme.surfaceContainerLightHighContrast
import com.example.ui.theme.surfaceContainerLightMediumContrast
import com.example.ui.theme.surfaceContainerLowDark
import com.example.ui.theme.surfaceContainerLowDarkHighContrast
import com.example.ui.theme.surfaceContainerLowDarkMediumContrast
import com.example.ui.theme.surfaceContainerLowLight
import com.example.ui.theme.surfaceContainerLowLightHighContrast
import com.example.ui.theme.surfaceContainerLowLightMediumContrast
import com.example.ui.theme.surfaceContainerLowestDark
import com.example.ui.theme.surfaceContainerLowestDarkHighContrast
import com.example.ui.theme.surfaceContainerLowestDarkMediumContrast
import com.example.ui.theme.surfaceContainerLowestLight
import com.example.ui.theme.surfaceContainerLowestLightHighContrast
import com.example.ui.theme.surfaceContainerLowestLightMediumContrast
import com.example.ui.theme.surfaceDark
import com.example.ui.theme.surfaceDarkHighContrast
import com.example.ui.theme.surfaceDarkMediumContrast
import com.example.ui.theme.surfaceDimDark
import com.example.ui.theme.surfaceDimDarkHighContrast
import com.example.ui.theme.surfaceDimDarkMediumContrast
import com.example.ui.theme.surfaceDimLight
import com.example.ui.theme.surfaceDimLightHighContrast
import com.example.ui.theme.surfaceDimLightMediumContrast
import com.example.ui.theme.surfaceLight
import com.example.ui.theme.surfaceLightHighContrast
import com.example.ui.theme.surfaceLightMediumContrast
import com.example.ui.theme.surfaceVariantDark
import com.example.ui.theme.surfaceVariantDarkHighContrast
import com.example.ui.theme.surfaceVariantDarkMediumContrast
import com.example.ui.theme.surfaceVariantLight
import com.example.ui.theme.surfaceVariantLightHighContrast
import com.example.ui.theme.surfaceVariantLightMediumContrast
import com.example.ui.theme.tertiaryContainerDark
import com.example.ui.theme.tertiaryContainerDarkHighContrast
import com.example.ui.theme.tertiaryContainerDarkMediumContrast
import com.example.ui.theme.tertiaryContainerLight
import com.example.ui.theme.tertiaryContainerLightHighContrast
import com.example.ui.theme.tertiaryContainerLightMediumContrast
import com.example.ui.theme.tertiaryDark
import com.example.ui.theme.tertiaryDarkHighContrast
import com.example.ui.theme.tertiaryDarkMediumContrast
import com.example.ui.theme.tertiaryLight
import com.example.ui.theme.tertiaryLightHighContrast
import com.example.ui.theme.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun WeatherAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )

}

