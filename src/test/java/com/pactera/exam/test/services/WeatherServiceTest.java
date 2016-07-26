package com.pactera.exam.test.services;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pactera.exam.model.City;
import com.pactera.exam.service.WeatherService;

public class WeatherServiceTest {
	WeatherService webService = new WeatherService();
	@Test
	public void testGetWetherDetails() {
		City city = new City();
		city.setCity("Melbourne,au");
		assertNotNull(webService.getWeatherDetails(city));
	}
	
	@Test
	public void testGetCityMap() {
		City city = new City();
		city.setCity("Melbourne,au");
		assertNotNull(webService.getCityMap());
	}
}
