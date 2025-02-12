package com.example.ui

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.compose.runtime.Composable
import androidx.core.content.ContextCompat

/**
 * created by Karim Haggagi Hassan Elsayed on 2/12/25
 **/

@Composable
fun Context.CheckForPermissions(
    onPermissionGranted: @Composable () -> Unit,
    onPermissionDenied: @Composable () -> Unit
) {
    when (
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )
    ) {
        PackageManager.PERMISSION_GRANTED -> {
            onPermissionGranted()
        }
        PackageManager.PERMISSION_DENIED -> {
            onPermissionDenied()
        }
    }
}
