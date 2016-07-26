package com.pactera.exam.service;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pactera.exam.Util.Constant;
import com.pactera.exam.model.City;
import com.pactera.exam.model.Weather;
import com.pactera.exam.model.WeatherDetails;

@Service
public class WeatherService {

	ResourceBundle cities; 
	ResourceBundle applicationProp;
	RestTemplate restTemplate;
	
	public WeatherService(){
		cities = ResourceBundle.getBundle("cities");
		applicationProp = ResourceBundle.getBundle("application");
		restTemplate = new RestTemplate();
	}
	
	public Map<String,String> getCityMap(){
		Map<String,String> country = new LinkedHashMap<String,String>();
		Set<String> keys = cities.keySet();
		for(String key : keys){
			country.put(cities.getString(key), key);
		}
		return country;
	}
	
	public WeatherDetails getWeatherDetails(City city){
		String uri = MessageFormat.format(applicationProp.getString(Constant.URI), city.getCity(), applicationProp.getString(Constant.APPID));
		WeatherDetails weatherDetails = restTemplate.getForObject(uri, WeatherDetails.class);
		weatherDetails.setDt(new Date(weatherDetails.getDt().getTime() * 1000));
		return weatherDetails;
	}
}
