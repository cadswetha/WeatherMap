package com.cads.weathermap


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val apiKey : String = "5047949cd60ed4752224b61d58fd8c19"
    private val url : String = "https://api.openweathermap.org/data/2.5/weather"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button:Button = findViewById(R.id.button)
        val evRegion : EditText = findViewById(R.id.evRegion)
        val evCountry :EditText = findViewById(R.id.rvCountry)
        val tvTemp :TextView = findViewById(R.id.tvTemp)
        val tvFeelsLike :TextView = findViewById(R.id.tvFeelsLike)
        val tvHumidity :TextView = findViewById(R.id.tvHumidity)
        val tvWind :TextView = findViewById(R.id.tvWindSpeed)
        button.setOnClickListener {

            var inputVal :String
            val city :String = evRegion.text.toString()
            val country :String = evCountry.text.toString()
            if(city==""){
                Toast.makeText(this,"Enter the city name!",Toast.LENGTH_SHORT).show()
            }
            else {
                evRegion.text.clear()
                if (country == "") {
                    inputVal = city
                }
                else{
                    inputVal = "$city,$country"
                }
                val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
                viewModel.getWeather(inputVal,apiKey)
                viewModel.myResponse.observe(this, Observer{
                    val kTemp = it.main?.temp
                    val celTemp = kTemp!! - 273
                    tvTemp.text = "Temperature: ${celTemp} C"
                    tvFeelsLike.text = "Feels like: ${it.main?.feelsLike}"
                    tvHumidity.text = "Humidity: ${it.main?.humidity}"
                    tvWind.text = "Wind: ${it.wind?.speed}"

                })
             }
        }
    }
}

