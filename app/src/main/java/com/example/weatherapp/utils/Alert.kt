package com.example.weatherapp.utils

import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.weatherapp.R

fun showAlert(context: Context, text: String, onPositiveBtnClick: (() -> Unit)? = null) {
    val factory = LayoutInflater.from(context)
    val deleteDialogView: View = factory.inflate(R.layout.alert, null)
    val dialog = AlertDialog.Builder(context).create()
    dialog.setView(deleteDialogView)
    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

    val alertPostiveBtn = deleteDialogView.findViewById<TextView>(R.id.btn_ok)
    val alertText = deleteDialogView.findViewById<TextView>(R.id.alert_message)
    alertText.text = text
    alertPostiveBtn.setOnClickListener {
        dialog.dismiss()
        onPositiveBtnClick?.let { it1 -> it1() }
    }

    dialog.show()
}