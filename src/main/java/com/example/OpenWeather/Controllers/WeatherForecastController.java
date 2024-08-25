package com.example.OpenWeather.Controllers;

import com.example.OpenWeather.Models.Weather;
import com.example.OpenWeather.Services.HourlyForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forecast/hourly")
public class WeatherForecastController {

    @Autowired
    public HourlyForecastService hourlyForecastService;

    @GetMapping
    public ResponseEntity<Weather> getHourlyWeatherForecast(@RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("apiKey") String apiKey) {
        //Basic Check
        if(lat < -90 || lat > 90 || lon < -180 || lon > 180) {
            return  new ResponseEntity<>(HttpStatusCode.valueOf(400));
        } else if (apiKey == null || apiKey.isEmpty()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Weather weather = hourlyForecastService.getHourlyWeatherForecast(lat, lon, apiKey);
        return new ResponseEntity<>(weather, HttpStatusCode.valueOf(200));
    }

}
