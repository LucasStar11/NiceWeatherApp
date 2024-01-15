package com.example.domain.models

data class HourlyWeather(
    val day: String? = null,
    val time: String? = null,
    val temp: Int = 0,
    val tempHigh: Int = 0,
    val tempLow: Int = 0,
    val clouds: Int = 0,
    val pop: Int = 0,
    val wind: Int = 0,
    val humidity: Int = 0,
    val pressure: Int = 0
)