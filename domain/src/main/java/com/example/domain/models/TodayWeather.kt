package com.example.domain.models

data class TodayWeather(
    val city: String,
    val temp: Int = 0,
    val wind: Int = 0,
    val humidity: Int = 0,
    val clouds: Int = 0,
    val pop: Int = 0,
    val pressure: Int = 0
)