package com.example.ui

import android.Manifest
import android.app.Activity
import androidx.activity.result.ActivityResultLauncher
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource

/**
 * created by Karim Haggagi Hassan Elsayed on 2/5/25
 **/
@Composable
fun PermissionRationaleDialog(
    isDialogShown: MutableState<Boolean>,
    activityPermissionResult: ActivityResultLauncher<String>,
    showWeatherUI: MutableState<Boolean>
) {
    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onDismissRequest.
            isDialogShown.value = false
        },
        title = {
            Text(text = stringResource(R.string.location_rationale_title))
        },
        text = {
            Text(text = stringResource(R.string.location_rationale_description))
        },
        confirmButton = {
            Button(onClick = {
                isDialogShown.value = false
                activityPermissionResult.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
            }) {
                Text(text = stringResource(R.string.location_rationale_button_grant))
            }
            Button(onClick = {
                isDialogShown.value = false
                showWeatherUI.value = false
            }) {
                Text(text = stringResource(R.string.location_rationale_button_deny))
            }
        }
    )
}

@Composable
fun Activity.OnPermissionDenied(
    activityPermissionResult: ActivityResultLauncher<String>,
) {
    val showWeatherUI = remember { mutableStateOf(false) }
    if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION)) {
        val isDialogShown = remember { mutableStateOf(true) }
        if (isDialogShown.value) {
            PermissionRationaleDialog(
                isDialogShown,
                activityPermissionResult,
                showWeatherUI
            )
        }
    } else {
        activityPermissionResult.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
    }
}