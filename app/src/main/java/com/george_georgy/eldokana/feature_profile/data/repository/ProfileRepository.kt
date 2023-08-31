package com.george_georgy.eldokana.feature_profile.data.repository

import com.george_georgy.eldokana.feature_auth.data.local.UserPreference
import kotlinx.coroutines.flow.Flow

class ProfileRepository(
    private val userPreference: UserPreference
) {
    fun getUserProfile(): Flow<String> {
        return userPreference.getUserData()
    }
}