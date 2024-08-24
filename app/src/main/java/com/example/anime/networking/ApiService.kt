package com.example.anime.networking

import com.example.anime.model.Waifu
import okhttp3.Authenticator
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("angry")
    suspend fun getWaifu() : Waifu
}