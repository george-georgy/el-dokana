package com.george_georgy.eldokana.feature_profile.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_profile.data.repository.ProfileRepository
import com.george_georgy.eldokana.feature_profile.domain.mapper.toUser
import com.george_georgy.eldokana.feature_profile.domain.model.User
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel(
    private val profileRepository: ProfileRepository,
    private val gson: Gson

) : ViewModel() {

    private val _profileState = mutableStateOf(User())
    val profileState: State<User> = _profileState

    init {
        getProfile()
    }


    private fun getProfile(){
        viewModelScope.launch {
            profileRepository.getUserProfile().collect{user->
                val user = gson.fromJson(user, UserDto::class.java)
                _profileState.value  = user.toUser()

            }

        }
    }



}