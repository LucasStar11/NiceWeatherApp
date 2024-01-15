package com.example.niceweather.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.data.repository.CityWeatherRepositoryImpl
import com.example.domain.usecase.GetHourlyWeatherUseCase
import com.example.domain.usecase.GetTodayWeatherUseCase
import com.example.domain.usecase.GetWeeklyWeatherUseCase
import com.example.niceweather.R

class MainActivity: AppCompatActivity() {

    private val cityWeatherRepository by lazy(LazyThreadSafetyMode.NONE){
        CityWeatherRepositoryImpl("Volgograd")
    }

    val getHourlyWeatherUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetHourlyWeatherUseCase(cityWeatherRepository)
    }

    val getTodayWeatherUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetTodayWeatherUseCase(cityWeatherRepository)
    }

    val getWeeklyWeatherUseCase by lazy(LazyThreadSafetyMode.NONE){
        GetWeeklyWeatherUseCase(cityWeatherRepository)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
    }
}