package com.example.domain.models

data class CityWeather(
    val country: String,
    val city: String,
    val list: List<HourlyWeather>,
){}