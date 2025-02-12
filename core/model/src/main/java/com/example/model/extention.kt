package com.example.model

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

/**
 * created by Karim Haggagi Hassan Elsayed on 2/12/25
 **/
@Suppress("NewApi")
fun String.formatDate(): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    val dateTime = LocalDateTime.parse(this, formatter)
    return dateTime.toLocalDate().toString()
}

fun String.formatTime(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    val date = inputFormat.parse(this) // Parse to Date object
    return outputFormat.format(date!!) // Format to HH:mm
}