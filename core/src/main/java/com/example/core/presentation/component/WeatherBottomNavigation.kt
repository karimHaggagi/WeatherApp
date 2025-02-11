package com.example.core.presentation.component

import android.annotation.SuppressLint
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.presentation.Screens
import com.example.core.presentation.preview.PreviewLightDarkMode

/**
 * created by Karim Haggagi Hassan Elsayed on 2/10/25
 **/
@Composable
fun WeatherBottomNavigation(modifier: Modifier = Modifier, onIconClick: (Screens) -> Unit) {

    var isSelected by remember { mutableStateOf<Screens>(Screens.Home) }
    BottomNavigation(
        modifier = modifier
            .navigationBarsPadding()
            .padding(20.dp)
            .background(color = Color.Black, shape = RoundedCornerShape(40))
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        backgroundColor = Color.Black
    ) {

        WeatherBottomNavigationIem(
            title = R.string.home,
            icon = Icons.Outlined.Home,
            isSelected = isSelected == Screens.Home,
            onIconClick = {
                isSelected = Screens.Home
                onIconClick(Screens.Home)
            })

        WeatherBottomNavigationIem(
            title = R.string.search,
            icon = Icons.Outlined.Search,
            isSelected = isSelected == Screens.Search,
            onIconClick = {
                isSelected = Screens.Search
                onIconClick(Screens.Search)
            })

        WeatherBottomNavigationIem(
            title = R.string.search,
            icon = Icons.Outlined.Settings,
            isSelected = isSelected == Screens.Settings,
            onIconClick = {
                isSelected = Screens.Settings
                onIconClick(Screens.Settings)
            })
    }
}

@Composable
fun RowScope.WeatherBottomNavigationIem(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    icon: ImageVector,
    isSelected: Boolean = false,
    onIconClick: () -> Unit,
) {

    val backgroundModifier = if (isSelected) {
        modifier
            .background(color = Blue, shape = CircleShape)
            .padding(10.dp)
    } else {
        modifier
    }
    BottomNavigationItem(
        selected = isSelected,
        onClick = { onIconClick() },
        icon = {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    modifier = backgroundModifier,
                    imageVector = icon,
                    contentDescription = stringResource(title),
                    tint = Color.White
                )
                AnimatedVisibility(visible = !isSelected) {
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        text = stringResource(title),
                        color = Color(0xFFFFFFFF),
                        fontSize = 9.sp
                    )
                }
            }
        })
}

@PreviewLightDarkMode
@Composable
private fun WeatherBottomNavigationPreview() {
    WeatherBottomNavigation {}
}