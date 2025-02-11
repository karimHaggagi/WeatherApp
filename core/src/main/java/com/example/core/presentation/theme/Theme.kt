package com.example.core.presentation.theme

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
import com.example.core.presentation.theme.backgroundDark
import com.example.core.presentation.theme.backgroundDarkHighContrast
import com.example.core.presentation.theme.backgroundDarkMediumContrast
import com.example.core.presentation.theme.backgroundLight
import com.example.core.presentation.theme.backgroundLightHighContrast
import com.example.core.presentation.theme.backgroundLightMediumContrast
import com.example.core.presentation.theme.errorContainerDark
import com.example.core.presentation.theme.errorContainerDarkHighContrast
import com.example.core.presentation.theme.errorContainerDarkMediumContrast
import com.example.core.presentation.theme.errorContainerLight
import com.example.core.presentation.theme.errorContainerLightHighContrast
import com.example.core.presentation.theme.errorContainerLightMediumContrast
import com.example.core.presentation.theme.errorDark
import com.example.core.presentation.theme.errorDarkHighContrast
import com.example.core.presentation.theme.errorDarkMediumContrast
import com.example.core.presentation.theme.errorLight
import com.example.core.presentation.theme.errorLightHighContrast
import com.example.core.presentation.theme.errorLightMediumContrast
import com.example.core.presentation.theme.inverseOnSurfaceDark
import com.example.core.presentation.theme.inverseOnSurfaceDarkHighContrast
import com.example.core.presentation.theme.inverseOnSurfaceDarkMediumContrast
import com.example.core.presentation.theme.inverseOnSurfaceLight
import com.example.core.presentation.theme.inverseOnSurfaceLightHighContrast
import com.example.core.presentation.theme.inverseOnSurfaceLightMediumContrast
import com.example.core.presentation.theme.inversePrimaryDark
import com.example.core.presentation.theme.inversePrimaryDarkHighContrast
import com.example.core.presentation.theme.inversePrimaryDarkMediumContrast
import com.example.core.presentation.theme.inversePrimaryLight
import com.example.core.presentation.theme.inversePrimaryLightHighContrast
import com.example.core.presentation.theme.inversePrimaryLightMediumContrast
import com.example.core.presentation.theme.inverseSurfaceDark
import com.example.core.presentation.theme.inverseSurfaceDarkHighContrast
import com.example.core.presentation.theme.inverseSurfaceDarkMediumContrast
import com.example.core.presentation.theme.inverseSurfaceLight
import com.example.core.presentation.theme.inverseSurfaceLightHighContrast
import com.example.core.presentation.theme.inverseSurfaceLightMediumContrast
import com.example.core.presentation.theme.onBackgroundDark
import com.example.core.presentation.theme.onBackgroundDarkHighContrast
import com.example.core.presentation.theme.onBackgroundDarkMediumContrast
import com.example.core.presentation.theme.onBackgroundLight
import com.example.core.presentation.theme.onBackgroundLightHighContrast
import com.example.core.presentation.theme.onBackgroundLightMediumContrast
import com.example.core.presentation.theme.onErrorContainerDark
import com.example.core.presentation.theme.onErrorContainerDarkHighContrast
import com.example.core.presentation.theme.onErrorContainerDarkMediumContrast
import com.example.core.presentation.theme.onErrorContainerLight
import com.example.core.presentation.theme.onErrorContainerLightHighContrast
import com.example.core.presentation.theme.onErrorContainerLightMediumContrast
import com.example.core.presentation.theme.onErrorDark
import com.example.core.presentation.theme.onErrorDarkHighContrast
import com.example.core.presentation.theme.onErrorDarkMediumContrast
import com.example.core.presentation.theme.onErrorLight
import com.example.core.presentation.theme.onErrorLightHighContrast
import com.example.core.presentation.theme.onErrorLightMediumContrast
import com.example.core.presentation.theme.onPrimaryContainerDark
import com.example.core.presentation.theme.onPrimaryContainerDarkHighContrast
import com.example.core.presentation.theme.onPrimaryContainerDarkMediumContrast
import com.example.core.presentation.theme.onPrimaryContainerLight
import com.example.core.presentation.theme.onPrimaryContainerLightHighContrast
import com.example.core.presentation.theme.onPrimaryContainerLightMediumContrast
import com.example.core.presentation.theme.onPrimaryDark
import com.example.core.presentation.theme.onPrimaryDarkHighContrast
import com.example.core.presentation.theme.onPrimaryDarkMediumContrast
import com.example.core.presentation.theme.onPrimaryLight
import com.example.core.presentation.theme.onPrimaryLightHighContrast
import com.example.core.presentation.theme.onPrimaryLightMediumContrast
import com.example.core.presentation.theme.onSecondaryContainerDark
import com.example.core.presentation.theme.onSecondaryContainerDarkHighContrast
import com.example.core.presentation.theme.onSecondaryContainerDarkMediumContrast
import com.example.core.presentation.theme.onSecondaryContainerLight
import com.example.core.presentation.theme.onSecondaryContainerLightHighContrast
import com.example.core.presentation.theme.onSecondaryContainerLightMediumContrast
import com.example.core.presentation.theme.onSecondaryDark
import com.example.core.presentation.theme.onSecondaryDarkHighContrast
import com.example.core.presentation.theme.onSecondaryDarkMediumContrast
import com.example.core.presentation.theme.onSecondaryLight
import com.example.core.presentation.theme.onSecondaryLightHighContrast
import com.example.core.presentation.theme.onSecondaryLightMediumContrast
import com.example.core.presentation.theme.onSurfaceDark
import com.example.core.presentation.theme.onSurfaceDarkHighContrast
import com.example.core.presentation.theme.onSurfaceDarkMediumContrast
import com.example.core.presentation.theme.onSurfaceLight
import com.example.core.presentation.theme.onSurfaceLightHighContrast
import com.example.core.presentation.theme.onSurfaceLightMediumContrast
import com.example.core.presentation.theme.onSurfaceVariantDark
import com.example.core.presentation.theme.onSurfaceVariantDarkHighContrast
import com.example.core.presentation.theme.onSurfaceVariantDarkMediumContrast
import com.example.core.presentation.theme.onSurfaceVariantLight
import com.example.core.presentation.theme.onSurfaceVariantLightHighContrast
import com.example.core.presentation.theme.onSurfaceVariantLightMediumContrast
import com.example.core.presentation.theme.onTertiaryContainerDark
import com.example.core.presentation.theme.onTertiaryContainerDarkHighContrast
import com.example.core.presentation.theme.onTertiaryContainerDarkMediumContrast
import com.example.core.presentation.theme.onTertiaryContainerLight
import com.example.core.presentation.theme.onTertiaryContainerLightHighContrast
import com.example.core.presentation.theme.onTertiaryContainerLightMediumContrast
import com.example.core.presentation.theme.onTertiaryDark
import com.example.core.presentation.theme.onTertiaryDarkHighContrast
import com.example.core.presentation.theme.onTertiaryDarkMediumContrast
import com.example.core.presentation.theme.onTertiaryLight
import com.example.core.presentation.theme.onTertiaryLightHighContrast
import com.example.core.presentation.theme.onTertiaryLightMediumContrast
import com.example.core.presentation.theme.outlineDark
import com.example.core.presentation.theme.outlineDarkHighContrast
import com.example.core.presentation.theme.outlineDarkMediumContrast
import com.example.core.presentation.theme.outlineLight
import com.example.core.presentation.theme.outlineLightHighContrast
import com.example.core.presentation.theme.outlineLightMediumContrast
import com.example.core.presentation.theme.outlineVariantDark
import com.example.core.presentation.theme.outlineVariantDarkHighContrast
import com.example.core.presentation.theme.outlineVariantDarkMediumContrast
import com.example.core.presentation.theme.outlineVariantLight
import com.example.core.presentation.theme.outlineVariantLightHighContrast
import com.example.core.presentation.theme.outlineVariantLightMediumContrast
import com.example.core.presentation.theme.primaryContainerDark
import com.example.core.presentation.theme.primaryContainerDarkHighContrast
import com.example.core.presentation.theme.primaryContainerDarkMediumContrast
import com.example.core.presentation.theme.primaryContainerLight
import com.example.core.presentation.theme.primaryContainerLightHighContrast
import com.example.core.presentation.theme.primaryContainerLightMediumContrast
import com.example.core.presentation.theme.primaryDark
import com.example.core.presentation.theme.primaryDarkHighContrast
import com.example.core.presentation.theme.primaryDarkMediumContrast
import com.example.core.presentation.theme.primaryLight
import com.example.core.presentation.theme.primaryLightHighContrast
import com.example.core.presentation.theme.primaryLightMediumContrast
import com.example.core.presentation.theme.scrimDark
import com.example.core.presentation.theme.scrimDarkHighContrast
import com.example.core.presentation.theme.scrimDarkMediumContrast
import com.example.core.presentation.theme.scrimLight
import com.example.core.presentation.theme.scrimLightHighContrast
import com.example.core.presentation.theme.scrimLightMediumContrast
import com.example.core.presentation.theme.secondaryContainerDark
import com.example.core.presentation.theme.secondaryContainerDarkHighContrast
import com.example.core.presentation.theme.secondaryContainerDarkMediumContrast
import com.example.core.presentation.theme.secondaryContainerLight
import com.example.core.presentation.theme.secondaryContainerLightHighContrast
import com.example.core.presentation.theme.secondaryContainerLightMediumContrast
import com.example.core.presentation.theme.secondaryDark
import com.example.core.presentation.theme.secondaryDarkHighContrast
import com.example.core.presentation.theme.secondaryDarkMediumContrast
import com.example.core.presentation.theme.secondaryLight
import com.example.core.presentation.theme.secondaryLightHighContrast
import com.example.core.presentation.theme.secondaryLightMediumContrast
import com.example.core.presentation.theme.surfaceBrightDark
import com.example.core.presentation.theme.surfaceBrightDarkHighContrast
import com.example.core.presentation.theme.surfaceBrightDarkMediumContrast
import com.example.core.presentation.theme.surfaceBrightLight
import com.example.core.presentation.theme.surfaceBrightLightHighContrast
import com.example.core.presentation.theme.surfaceBrightLightMediumContrast
import com.example.core.presentation.theme.surfaceContainerDark
import com.example.core.presentation.theme.surfaceContainerDarkHighContrast
import com.example.core.presentation.theme.surfaceContainerDarkMediumContrast
import com.example.core.presentation.theme.surfaceContainerHighDark
import com.example.core.presentation.theme.surfaceContainerHighDarkHighContrast
import com.example.core.presentation.theme.surfaceContainerHighDarkMediumContrast
import com.example.core.presentation.theme.surfaceContainerHighLight
import com.example.core.presentation.theme.surfaceContainerHighLightHighContrast
import com.example.core.presentation.theme.surfaceContainerHighLightMediumContrast
import com.example.core.presentation.theme.surfaceContainerHighestDark
import com.example.core.presentation.theme.surfaceContainerHighestDarkHighContrast
import com.example.core.presentation.theme.surfaceContainerHighestDarkMediumContrast
import com.example.core.presentation.theme.surfaceContainerHighestLight
import com.example.core.presentation.theme.surfaceContainerHighestLightHighContrast
import com.example.core.presentation.theme.surfaceContainerHighestLightMediumContrast
import com.example.core.presentation.theme.surfaceContainerLight
import com.example.core.presentation.theme.surfaceContainerLightHighContrast
import com.example.core.presentation.theme.surfaceContainerLightMediumContrast
import com.example.core.presentation.theme.surfaceContainerLowDark
import com.example.core.presentation.theme.surfaceContainerLowDarkHighContrast
import com.example.core.presentation.theme.surfaceContainerLowDarkMediumContrast
import com.example.core.presentation.theme.surfaceContainerLowLight
import com.example.core.presentation.theme.surfaceContainerLowLightHighContrast
import com.example.core.presentation.theme.surfaceContainerLowLightMediumContrast
import com.example.core.presentation.theme.surfaceContainerLowestDark
import com.example.core.presentation.theme.surfaceContainerLowestDarkHighContrast
import com.example.core.presentation.theme.surfaceContainerLowestDarkMediumContrast
import com.example.core.presentation.theme.surfaceContainerLowestLight
import com.example.core.presentation.theme.surfaceContainerLowestLightHighContrast
import com.example.core.presentation.theme.surfaceContainerLowestLightMediumContrast
import com.example.core.presentation.theme.surfaceDark
import com.example.core.presentation.theme.surfaceDarkHighContrast
import com.example.core.presentation.theme.surfaceDarkMediumContrast
import com.example.core.presentation.theme.surfaceDimDark
import com.example.core.presentation.theme.surfaceDimDarkHighContrast
import com.example.core.presentation.theme.surfaceDimDarkMediumContrast
import com.example.core.presentation.theme.surfaceDimLight
import com.example.core.presentation.theme.surfaceDimLightHighContrast
import com.example.core.presentation.theme.surfaceDimLightMediumContrast
import com.example.core.presentation.theme.surfaceLight
import com.example.core.presentation.theme.surfaceLightHighContrast
import com.example.core.presentation.theme.surfaceLightMediumContrast
import com.example.core.presentation.theme.surfaceVariantDark
import com.example.core.presentation.theme.surfaceVariantDarkHighContrast
import com.example.core.presentation.theme.surfaceVariantDarkMediumContrast
import com.example.core.presentation.theme.surfaceVariantLight
import com.example.core.presentation.theme.surfaceVariantLightHighContrast
import com.example.core.presentation.theme.surfaceVariantLightMediumContrast
import com.example.core.presentation.theme.tertiaryContainerDark
import com.example.core.presentation.theme.tertiaryContainerDarkHighContrast
import com.example.core.presentation.theme.tertiaryContainerDarkMediumContrast
import com.example.core.presentation.theme.tertiaryContainerLight
import com.example.core.presentation.theme.tertiaryContainerLightHighContrast
import com.example.core.presentation.theme.tertiaryContainerLightMediumContrast
import com.example.core.presentation.theme.tertiaryDark
import com.example.core.presentation.theme.tertiaryDarkHighContrast
import com.example.core.presentation.theme.tertiaryDarkMediumContrast
import com.example.core.presentation.theme.tertiaryLight
import com.example.core.presentation.theme.tertiaryLightHighContrast
import com.example.core.presentation.theme.tertiaryLightMediumContrast

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

