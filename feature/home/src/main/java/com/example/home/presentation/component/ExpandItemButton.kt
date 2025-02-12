package com.example.home.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ui.preview.PreviewLightDarkMode
import com.example.home.R

/**
 * created by Karim Haggagi Hassan Elsayed on 2/3/25
 **/
@Composable
fun ExpandItemButton(
    modifier: Modifier = Modifier, expanded: Boolean,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@PreviewLightDarkMode
@Composable
private fun ExpandItemButtonPreview() {
    ExpandItemButton(expanded = true) { }
}