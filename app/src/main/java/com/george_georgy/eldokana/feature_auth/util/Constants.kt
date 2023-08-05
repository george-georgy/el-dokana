package com.george_georgy.eldokana.feature_auth.util

import androidx.datastore.preferences.core.stringPreferencesKey

object Constants {

    const val SPLASH_SCREEN_DURATION = 3000L
    const val AUTH_PREFERENCES = "AUTH_PREFERENCES"
    val USER_AUTH_KEY = stringPreferencesKey(name = "user_auth_key")
    val USER_DATA_KEY = stringPreferencesKey("user_data_key")
}
