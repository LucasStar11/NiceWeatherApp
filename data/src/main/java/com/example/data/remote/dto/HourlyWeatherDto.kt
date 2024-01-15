package com.example.data.remote.dto

import com.example.domain.models.HourlyWeather
import java.text.SimpleDateFormat
import java.util.Date;

data class HourlyWeatherDto(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val rain: Rain,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {


    fun toHourlyWeather(): HourlyWeather {
        val sdfDay = SimpleDateFormat("dd/MM/yyyy")
        val sdfTime = SimpleDateFormat("hh:mm")
        val netDate = Date(dt.toLong() * 1000)
        return HourlyWeather(
            day = sdfDay.format(netDate),
            time = sdfTime.format(netDate),
            temp = main.temp.toInt(),
            tempHigh = main.temp_max.toInt(),
            tempLow = main.temp_min.toInt(),
            clouds = clouds.all,
            pop = pop.toInt(),
            wind = wind.speed.toInt(),
            humidity = main.humidity,
            pressure = main.pressure
        )
    }
}