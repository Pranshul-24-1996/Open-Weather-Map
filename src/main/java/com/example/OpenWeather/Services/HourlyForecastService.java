package com.example.OpenWeather.Services;

import com.example.OpenWeather.Models.Weather;

public interface HourlyForecastService {

    public Weather getHourlyWeatherForecast(double lat,double lon, String apiKey);
}
