package com.cads.weathermap.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WeatherNetwork {
    const val buildUrl ="https://api.openweathermap.org/data/2.5/"
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(buildUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPI::class.java)
    }
}