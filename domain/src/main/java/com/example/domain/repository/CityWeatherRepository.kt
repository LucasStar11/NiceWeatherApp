package com.example.domain.repository
import com.example.domain.models.DailyWeather
import com.example.domain.models.HourlyWeather
import com.example.domain.models.TodayWeather
import com.example.domain.utils.Resource


interface CityWeatherRepository{
    suspend fun getWeeklyWeather(): Resource<List<DailyWeather>>
    suspend fun getTodayWeather(): Resource<TodayWeather>
    suspend fun getHourlyWeather(): Resource<List<HourlyWeather>>
}