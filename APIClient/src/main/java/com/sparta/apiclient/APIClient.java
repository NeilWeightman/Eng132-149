package com.sparta.apiclient;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class APIClient {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        WeatherMain londonWeather = null;
        try {
            londonWeather = mapper.readValue(
                    new URL("https://api.openweathermap.org/data/2.5/weather?q=Birmingham,UK&appid=12ac42b3fe25e0c0180afa789227dc8c"),
                    WeatherMain.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(londonWeather.getMain().getTemp());
    }
}