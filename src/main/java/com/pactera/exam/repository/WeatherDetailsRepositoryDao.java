package com.pactera.exam.repository;

import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.pactera.exam.Util.Constant;
import com.pactera.exam.model.City;
import com.pactera.exam.model.Weather;
import com.pactera.exam.model.WeatherDetails;

@Repository
public interface WeatherDetailsRepositoryDao{
	
	public WeatherDetails getWeatherByCity(City city);
}
