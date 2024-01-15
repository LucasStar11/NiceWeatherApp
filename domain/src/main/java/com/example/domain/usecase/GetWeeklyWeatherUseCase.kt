package com.example.domain.usecase

import com.example.domain.models.DailyWeather
import com.example.domain.repository.CityWeatherRepository
import com.example.domain.utils.Resource

class GetWeeklyWeatherUseCase(private val cityWeatherRepository: CityWeatherRepository) {

    suspend fun execute() : Resource<List<DailyWeather>> {
        return cityWeatherRepository.getWeeklyWeather()
    }

}