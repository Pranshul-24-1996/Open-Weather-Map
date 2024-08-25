package com.example.OpenWeather.Controllers;

import com.example.OpenWeather.Models.Weather;
import com.example.OpenWeather.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Weather> getCurrentWeather(@RequestParam("lat") double lat, @RequestParam("lon") double lon, @RequestParam("apiKey") String apiKey) {
        //Basic checks
        if(lat < -90.0 || lat > 90.0 || lon < -180.0 || lon > 180.0) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        } else if (apiKey == null || apiKey.isEmpty()) {
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        Weather weather = weatherService.getCurrentWeather(lat, lon, apiKey);
        return new ResponseEntity<>(weather, HttpStatusCode.valueOf(200));
    }
}
