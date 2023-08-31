package com.george_georgy.eldokana.feature_auth.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_auth.util.Constants.USER_AUTH_KEY
import com.george_georgy.eldokana.feature_auth.util.Constants.USER_DATA_KEY
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class UserPreference(
    private val userDataStore: DataStore<Preferences>,
    private val gson: Gson
) {

    // saving and getting Token from datastore
    suspend fun saveUserToken(userToken: String?) {
        userDataStore.edit { preferences ->
            preferences[USER_AUTH_KEY] = userToken?: ""

        }
    }

    fun getUserToken(): Flow<String> {
        return userDataStore.data.map { preferences ->
            preferences[USER_AUTH_KEY] ?: ""
        }
    }

    suspend fun clearUserToken() {
        userDataStore.edit { preferences ->
            preferences[USER_AUTH_KEY] = ""
        }
    }

    // saving and getting user data from datastore
    suspend fun saveUserdata(user: UserDto) {
        userDataStore.edit { preferences ->
            preferences[USER_DATA_KEY] = gson.toJson(user)
        }
    }

    fun getUserData(): Flow<String> {
        return userDataStore.data.map { preferences ->
            preferences[USER_DATA_KEY] ?: ""
        }
    }






}