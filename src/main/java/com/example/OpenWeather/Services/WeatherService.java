package com.example.OpenWeather.Services;

import com.example.OpenWeather.Models.Weather;

public interface WeatherService {

    public Weather getCurrentWeather(double lat, double lon, String apiKey);
}
