package com.example.domain.models


data class DailyWeather(
    val day: String? = null,
    val tempHigh: Int = 0,
    val tempLow: Int = 0,
    val clouds: Int = 0,
    val pop: Int = 0,
)