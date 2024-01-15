package com.example.domain.usecase

import com.example.domain.models.TodayWeather
import com.example.domain.repository.CityWeatherRepository
import com.example.domain.utils.Resource

class GetTodayWeatherUseCase (
    private val cityWeatherRepository: CityWeatherRepository
){

    suspend fun execute(): Resource<TodayWeather> {
        return cityWeatherRepository.getTodayWeather()
    }
}