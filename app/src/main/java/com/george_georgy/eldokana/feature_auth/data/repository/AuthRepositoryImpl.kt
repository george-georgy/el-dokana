package com.george_georgy.eldokana.feature_auth.data.repository

import com.bumptech.glide.load.HttpException
import com.george_georgy.eldokana.core.utils.Resource
import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_auth.data.local.UserPreference
import com.george_georgy.eldokana.feature_auth.data.remote.AuthApi
import com.george_georgy.eldokana.feature_auth.data.remote.request.LoginRequest
import com.george_georgy.eldokana.feature_auth.domain.repository.AuthRepository
import com.george_georgy.eldokana.feature_auth.util.AuthResult
import kotlinx.coroutines.flow.first
import timber.log.Timber
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi : AuthApi,
    private val userPreference: UserPreference

) : AuthRepository {


    override suspend fun loginUser(username: String, password: String): AuthResult<Unit> {
        Timber.d("Login called")

        return try {

            val response = authApi.loginUser(
                LoginRequest(
                    username = username,
                    password = password
                )
            )
            Timber.d("Login Token: ${response.token}")

            getUserData(username)?.let { userPreference.saveUserdata(it) }
            userPreference.saveUserToken(response.token)
            AuthResult.Authorized()
        } catch (e: HttpException) {
            if (e.statusCode == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            AuthResult.UnknownError()
        }

    }


        override suspend fun autoLogin(): Resource<Unit> {

            val accessToken = userPreference.getUserToken().first()

            Timber.d("Auto login access token: $accessToken")

            return if (accessToken != "") {
                Resource.Success(Unit)
            } else {
                Resource.Error("")
            }
        }

        override suspend fun logout(): Resource<Unit> {
            return try {

                userPreference.clearUserToken()

                val fetchedToken = userPreference.getUserToken().first()

                Timber.d("token: $fetchedToken")

                if (fetchedToken.isEmpty()) {
                    Resource.Success(Unit)
                } else {
                    Resource.Error("Unknown Error")
                }
            } catch (e: Exception) {
                return Resource.Error("Unknown error occurred")
            }
        }

    private suspend fun getUserData(name: String): UserDto? {
        val allUsers = authApi.getAllUsers()
        return allUsers.find { it.username == name }
    }


}


