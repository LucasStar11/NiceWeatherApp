package com.example.data.remote

import com.example.data.remote.dto.CityWeatherDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("forecast?q={City}&units=metric&appid=43fdb6411b3de4244171aa82767e4db5")
    suspend fun getCityWeather(
        @Path("city") city: String
    ): CityWeatherDto
}