package com.example.data.repository

import com.example.data.remote.WeatherApi
import com.example.domain.models.DailyWeather
import com.example.domain.models.HourlyWeather
import com.example.domain.models.TodayWeather
import com.example.domain.repository.CityWeatherRepository
import com.example.domain.utils.Resource
import retrofit2.Retrofit


class CityWeatherRepositoryImpl(
    private val city: String
) : CityWeatherRepository {


     fun provideWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .build()
            .create(WeatherApi::class.java)
    }

    override suspend fun getWeeklyWeather(): Resource<List<DailyWeather>> {
        val api = provideWeatherApi()
        val hourlyList = api.getCityWeather(city).toCityWeather().list
        val groupedList = hourlyList.groupBy { it.day }
        val weeklyWeather: MutableList<DailyWeather> = ArrayList()
        for (day in groupedList.keys) {
            val daylyWeather = DailyWeather(
                day,
                groupedList.getValue(day).maxByOrNull { it.tempHigh }!!.tempHigh,
                groupedList.getValue(day).minByOrNull { it.tempLow }!!.tempLow,
                groupedList.getValue(day).maxByOrNull { it.clouds }!!.clouds,
                groupedList.getValue(day).maxByOrNull { it.pop }!!.pop
            )
            weeklyWeather.add(daylyWeather)
        }

        return try {
            Resource.Success(
                data = weeklyWeather
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getTodayWeather(): Resource<TodayWeather> {
        val api = provideWeatherApi()
        val nowWeather = api.getCityWeather(city).toCityWeather().list[0]

        val todayWeather = TodayWeather(
            city,
            nowWeather.temp,
            nowWeather.wind,
            nowWeather.humidity,
            nowWeather.clouds,
            nowWeather.pop,
            nowWeather.pressure
        )

        return try {
            Resource.Success(
                data = todayWeather
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }

    override suspend fun getHourlyWeather(): Resource<List<HourlyWeather>> {
        val api = provideWeatherApi()
        return try {
            Resource.Success(
                data = api.getCityWeather(city).toCityWeather().list.slice(0..7)
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}