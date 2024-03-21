package com.example.weatherapp.utils

import android.Manifest
import android.app.PendingIntent
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.renderscript.RenderScript
import androidx.core.content.ContextCompat
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest


fun Context.checkLocationPermission(
    onLocationPermissionGranted: () -> Unit,
    onLocationPermissionDenied: (permissions: String) -> Unit
) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationPermissionDenied(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            return
        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationPermissionDenied(
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            return
        }
    } else {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationPermissionDenied(
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            return

        }

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            onLocationPermissionDenied(
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            return
        }
    }

    onLocationPermissionGranted()
}

fun Context.checkIfGPSIsEnabled(onGpsClosed: () -> Unit, onGpsOpen: () -> Unit) {
    val locationManager =
        this.getSystemService(Context.LOCATION_SERVICE) as LocationManager?

    if (locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == false) {
        onGpsClosed()
    } else {
        onGpsOpen()
    }
}

fun Context.checkDeviceLocationSettings(
    resolve: Boolean = true,
    onGpsClosed: (exception: PendingIntent) -> Unit
) {

    val locationRequest = LocationRequest.create().apply {
        interval = 5000
        fastestInterval = 1000
        priority = PRIORITY_HIGH_ACCURACY
    }.apply {
        isWaitForAccurateLocation = true

    }

    val builder = LocationSettingsRequest.Builder().addLocationRequest(locationRequest)

    val settingsClient = LocationServices.getSettingsClient(this)
    val locationSettingsResponseTask =
        settingsClient.checkLocationSettings(builder.build())

    locationSettingsResponseTask.addOnFailureListener { exception ->
        if (exception is ResolvableApiException && resolve) {
            onGpsClosed(exception.resolution)
        }
    }
}

