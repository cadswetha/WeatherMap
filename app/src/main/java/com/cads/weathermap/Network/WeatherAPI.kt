package com.cads.weathermap.Network

import com.cads.weathermap.DAO.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET ("weather")
    suspend fun getWeather(@Query("q") place:String, @Query("APPID") apikey:String): WeatherData

}