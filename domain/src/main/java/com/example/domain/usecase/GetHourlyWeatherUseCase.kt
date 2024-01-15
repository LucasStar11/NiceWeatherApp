package com.example.domain.usecase

import com.example.domain.models.HourlyWeather
import com.example.domain.repository.CityWeatherRepository
import com.example.domain.utils.Resource

class GetHourlyWeatherUseCase (private val cityWeatherRepository: CityWeatherRepository){

    suspend fun execute(): Resource<List<HourlyWeather>> {
        return cityWeatherRepository.getHourlyWeather()
    }
}