package com.cads.weathermap

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cads.weathermap.DAO.WeatherData
import com.cads.weathermap.Network.WeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel :ViewModel() {
    val myResponse : MutableLiveData<WeatherData> = MutableLiveData()
    fun getWeather(place:String , apiKey:String){
        viewModelScope.launch(Dispatchers.IO) {
            myResponse.postValue(WeatherNetwork.retrofit.getWeather(place,apiKey))
        }
    }

}