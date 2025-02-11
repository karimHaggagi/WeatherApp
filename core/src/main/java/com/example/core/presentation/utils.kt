package com.example.core.presentation

import android.annotation.SuppressLint
import android.app.Activity
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.example.core.R
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.location.LocationSettingsResponse
import com.google.android.gms.location.LocationSettingsStatusCodes
import com.google.android.gms.location.Priority
import com.google.android.gms.tasks.Task
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * created by Karim Haggagi Hassan Elsayed on 2/4/25
 **/
fun iconIdForWeatherCondition(weatherId: Int): Int {


    when (weatherId) {
        in 200..232 -> {
            return R.drawable.art_storm
        }
        in 300..321 -> {
            return R.drawable.art_light_rain
        }
        in 500..504 -> {
            return R.drawable.art_rain
        }
        511 -> {
            return R.drawable.art_snow
        }
        in 520..531 -> {
            return R.drawable.art_rain
        }
        in 600..622 -> {
            return R.drawable.art_snow
        }
        in 701..761 -> {
            return R.drawable.art_fog
        }
        762, 771, 781 -> {
            return R.drawable.art_storm
        }
        800 -> {
            return R.drawable.art_clear
        }
        801 -> {
            return R.drawable.art_light_clouds
        }
        in 802..804 -> {
            return R.drawable.art_clouds
        }
        in 900..906 -> {
            return R.drawable.art_storm
        }
        in 958..962 -> {
            return R.drawable.art_storm
        }
        in 951..957 -> {
            return R.drawable.art_clear
        }
        else -> {
            return R.drawable.art_storm
        }
    }
}


fun createLocationRequest(
    activity: Activity,
    locationRequestLauncher: ActivityResultLauncher<IntentSenderRequest>,
    onLocationRequestSuccessful: () -> Unit
) {
    val locationRequest = LocationRequest.Builder(30_000L)
        .setPriority(Priority.PRIORITY_HIGH_ACCURACY) // PRIORITY_BALANCED_POWER_ACCURACY
        .build()

    val locationSettingsRequest = LocationSettingsRequest.Builder()
        .addLocationRequest(locationRequest)

    val task: Task<LocationSettingsResponse> =
        LocationServices.getSettingsClient(activity)
            .checkLocationSettings(locationSettingsRequest.build())

    task.addOnCompleteListener { response ->
        try {
            val result = response.getResult(ApiException::class.java)
            val hasLocationAccess = result.locationSettingsStates?.isLocationUsable == true
            if (hasLocationAccess) {
                onLocationRequestSuccessful()
            }
        } catch (exception: ApiException) {
            when (exception.statusCode) {
                LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                    val resolvable = exception as ResolvableApiException
                    val intentSender =
                        IntentSenderRequest.Builder(resolvable.resolution).build()
                    locationRequestLauncher.launch(intentSender)
                }
                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                    // Do nothing, location settings can't be changed
                }
            }
        }
    }
}

@SuppressLint("NewApi")
fun getCurrentDayFormatted(): String {
    // Get the current date
    val currentDate = LocalDate.now()

    // Define the desired format
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    println(currentDate.format(formatter))
    // Format the current date
    return currentDate.format(formatter)
}