package com.example.utils

import com.example.common.DataError
import com.example.ui.UiText


/**
 * created by Karim Haggagi on 1/5/25
 **/
fun DataError.toUiText(): UiText.StringResourceId {
    val resourceId = when(this){
        com.example.common.DataError.Local.DISK_FULL -> R.string.data_error_local_disk_full
        com.example.common.DataError.Local.UNKNOWN -> R.string.data_error_local_unknown
        com.example.common.DataError.Remote.REQUEST_TIMEOUT ->R.string.data_error_remote_too_many_requests
        com.example.common.DataError.Remote.TOO_MANY_REQUESTS -> R.string.data_error_remote_too_many_requests
        com.example.common.DataError.Remote.NO_INTERNET -> R.string.data_error_remote_no_internet
        com.example.common.DataError.Remote.SERVER -> R.string.data_error_remote_server_error
        com.example.common.DataError.Remote.SERIALIZATION -> R.string.data_error_remote_serialization_error
        com.example.common.DataError.Remote.UNKNOWN -> R.string.data_error_remote_unknown_error
    }
    return UiText.StringResourceId(resourceId)
}