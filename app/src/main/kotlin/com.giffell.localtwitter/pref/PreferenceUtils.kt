package com.giffell.localtwitter.pref

import android.content.SharedPreferences

class PreferenceUtils(
    private val sharedPreferences: SharedPreferences
) {

    fun setBoolean(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    companion object {
        const val USER_LOGGED_IN = "USER_LOGGED_IN"
        const val PREF_NAME = "pref"
    }
}