package com.example.anime.repository

import com.example.anime.networking.RetrofitClient

class Repository {
    private val apiService = RetrofitClient.apiService

    suspend fun getAngryWaifu() = apiService.getAngryWaifu()
}
