package com.example.anime.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor { chain ->
            val originalRequest = chain.request()
            val requestWithAuth = originalRequest.newBuilder()
                .addHeader("Authorization", "Njk2MDI2OTA3NzUzNTc4NTE2.MTcyNDUxNDI0OQ--.7145e34be744")
                .build()
            chain.proceed(requestWithAuth)
        }
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://waifu.it/api/v4/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}
