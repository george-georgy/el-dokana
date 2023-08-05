package com.george_georgy.eldokana.feature_auth.data.remote

import com.george_georgy.eldokana.core.utils.Constants.BASE_URL
import com.george_georgy.eldokana.feature_auth.data.dto.UserDto
import com.george_georgy.eldokana.feature_auth.data.remote.AuthApi
import com.george_georgy.eldokana.feature_auth.data.remote.request.LoginRequest
import com.george_georgy.eldokana.feature_auth.data.remote.response.LoginResponse
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthImpl(
    private val client: HttpClient
) : AuthApi {
    override suspend fun loginUser(loginRequest: LoginRequest): LoginResponse {

        return try {
            client.post<LoginResponse> {
                url("${BASE_URL}auth/login")
                contentType(ContentType.Application.Json)
                body = loginRequest
            }
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            LoginResponse("")
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            LoginResponse("")

        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            LoginResponse("")

        } catch(e: Exception) {
            println("Error: ${e.message}")
            LoginResponse("")
        }
    }





    override suspend fun getAllUsers(): List<UserDto> {

        return try {
            client.get {url("${BASE_URL}users/")}
        } catch(e: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ClientRequestException) {
            // 4xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: ServerResponseException) {
            // 5xx - responses
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch(e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }
}