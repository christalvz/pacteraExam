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
public class WeatherDetailsRepositoryImpl implements WeatherDetailsRepositoryDao{

	ResourceBundle applicationProp;
	RestTemplate restTemplate;
	
	public WeatherDetailsRepositoryImpl(){
		applicationProp = ResourceBundle.getBundle("application");
		restTemplate = new RestTemplate();
	}

	public WeatherDetails getWeatherByCity(City city){
		String uri = MessageFormat.format(applicationProp.getString(Constant.URI), city.getCity(), applicationProp.getString(Constant.APPID));
		WeatherDetails weatherDetails = restTemplate.getForObject(uri, WeatherDetails.class);

		return weatherDetails;
	}
}
