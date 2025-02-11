package com.example.core.presentation.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.presentation.getWeatherIconForPreview
import com.example.core.presentation.preview.PreviewLightDarkMode

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun ConditionsSection(
    modifier: Modifier = Modifier,
    conditionText: String,
    @StringRes conditionLabel: Int,
    @DrawableRes drawable: Int
) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .width(180.dp)
                .height(60.dp)
        ) {
            Text(
                text = conditionText,
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier.padding(horizontal = 4.dp, vertical = 4.dp)
            )
            ConditionsLabelSection(modifier, drawable, conditionLabel)
        }
    }
}

@PreviewLightDarkMode
@Composable
private fun ConditionsSectionPreview() {
    ConditionsSection(
        modifier = Modifier,
        conditionText = "Condition",
        conditionLabel = R.string.wind_label,
        drawable = getWeatherIconForPreview()
    )
}