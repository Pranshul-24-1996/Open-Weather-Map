package com.example.OpenWeather.dtos;

import com.example.OpenWeather.Models.Weather;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OpenWeatherMapDto {

    private Weather.Coord coord;
    private List<Weather.WeatherInfo> weather;
    private String base;
    private Weather.Main main;
    private int visibility;
    private Weather.Wind wind;
    private Weather.Rain rain;
    private Weather.Clouds clouds;
    private long dt;
    private Weather.Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    @Getter
    @Setter
    public static class Coord {
        private double lat;
        private double lon;
    }

    @Getter
    @Setter
    public static class WeatherInfo {
        private int id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    @Setter
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private int pressure;
        private int humidity;
        private int sea_level;
        private int grnd_level;
    }

    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private int deg;
        private double gust;
    }

    @Getter
    @Setter
    public static class Rain {
        // It indicates rain in one hour
        private double _1h;
    }

    @Getter
    @Setter
    public static class Clouds {
        private int all;
    }

    @Getter
    @Setter
    public static class Sys {
        private int type;
        private int id;
        private String country;
        private long sunrise;
        private long sunset;
    }
}
