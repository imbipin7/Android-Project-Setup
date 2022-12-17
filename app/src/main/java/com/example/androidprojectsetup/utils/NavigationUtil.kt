package com.example.androidprojectsetup.utils

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.example.androidprojectsetup.MainActivity
import com.example.androidprojectsetup.utils.ValidatorUtils.hideSoftKeyboard


/**Navigate using destination ID*/
fun View.navigateWithId(id: Int, bundle: Bundle? = null) = try {
    hideSoftKeyboard(MainActivity.context.get() as Activity)
    this.findNavController().navigate(id, bundle)
} catch (e: Exception) {
    e.printStackTrace()
}

/** Navigate to previous screen*/
fun View.navigateBack() = try {
    hideSoftKeyboard(MainActivity.context.get() as Activity)
    this.findNavController().navigateUp()
} catch (e: Exception) {
    e.printStackTrace()
}