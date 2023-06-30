package com.example.testnewsapp.api

import com.example.testnewsapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsApiImplementation {
    fun provideApi(): NewsApi = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(NewsApi::class.java)
}