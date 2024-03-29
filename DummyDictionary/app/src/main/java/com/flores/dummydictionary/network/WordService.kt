package com.flores.dummydictionary.network

import androidx.room.*
import com.flores.dummydictionary.network.dto.LoginRequest
import com.flores.dummydictionary.network.dto.LoginResponse
import com.flores.dummydictionary.network.dto.WordsResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface WordService {
    @GET("/words")
    suspend fun getAllWord(): WordsResponse

    @POST("/login")
    suspend fun  login(@Body credentials: LoginRequest): LoginResponse
}