package com.example.OpenWeather.Services;

import com.example.OpenWeather.Models.Weather;
import com.example.OpenWeather.dtos.OpenWeatherMapDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenWeatherMapWeatherService implements WeatherService {
    /*
    In this class we implement the WeatherService(i.e.Interface), which in turns
    means here we write our business logic
     */

    @Override
    public Weather getCurrentWeather(double lat, double lon, String apiKey) {
        /*
        Take the latitude and longitude from the user and call the below endpoint
        https://api.openweathermap.org/data/2.5/weather + lat + lon + apiKey
         */
        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        // RestTemplate is used to call 3rd party apis
        RestTemplate restTemplate = new RestTemplate();
        OpenWeatherMapDto openWeatherMapDto = restTemplate.getForObject(url, OpenWeatherMapDto.class);

        if (openWeatherMapDto == null) {
            throw new RuntimeException("Failed to fetch weather data");
        }
        return convertopenWeatherDtoToWeather(openWeatherMapDto);
    }

    private Weather convertopenWeatherDtoToWeather(OpenWeatherMapDto dto) {
        Weather weather = new Weather();
        weather.setCoord(dto.getCoord());
        weather.setWeather(dto.getWeather());
        weather.setBase(dto.getBase());
        weather.setMain(dto.getMain());
        weather.setVisibility(dto.getVisibility());
        weather.setWind(dto.getWind());
        weather.setRain(dto.getRain());
        weather.setClouds(dto.getClouds());
        weather.setDt(dto.getDt());
        weather.setSys(dto.getSys());
        weather.setTimezone(dto.getTimezone());
        weather.setId(dto.getId());
        weather.setName(dto.getName());
        weather.setCod(dto.getCod());

        return weather;
    }


}
