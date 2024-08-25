package com.example.anime.networking

import com.example.anime.model.AngryWaifu
import retrofit2.http.GET

interface ApiService {
    @GET("angry")
    suspend fun getAngryWaifu() : AngryWaifu
}
