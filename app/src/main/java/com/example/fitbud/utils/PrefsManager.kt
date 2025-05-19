package com.example.fitbud.utils

import android.content.Context

object PrefsManager {
    private const val PREFS_NAME = "prefs"

    fun saveUser(context: Context, email: String, password: String) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
    }

    fun getEmail(context: Context): String? {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getString("email", null)
    }

    fun getPassword(context: Context): String? {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getString("password", null)
    }

    fun saveDarkMode(context: Context, enabled: Boolean) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit().putBoolean("dark_mode", enabled).apply()
    }

    fun isDarkMode(context: Context): Boolean {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean("dark_mode", false)
    }
}
