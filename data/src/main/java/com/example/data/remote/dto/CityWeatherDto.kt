package com.example.data.remote.dto

import com.example.domain.models.CityWeather

data class CityWeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<HourlyWeatherDto>,
    val message: Int
) {
    fun toCityWeather(): CityWeather {
        return CityWeather(
            city = city.name,
            country = city.country,
            list = list.map { it.toHourlyWeather() }
        )
    }

}

