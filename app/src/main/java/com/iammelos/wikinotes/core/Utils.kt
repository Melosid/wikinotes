package com.iammelos.wikinotes.core

import android.util.Log
import com.iammelos.wikinotes.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())
    }
}