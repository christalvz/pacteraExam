package com.pactera.exam.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {
	Integer id;
	String name;
	Date dt;

	public Date getDt() {
		return dt;
	}

	public void setDt(Date dt) {
		this.dt = dt;
	}

	List<Weather> weather;
	WeatherWind wind;
	WeatherTemperature main;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public WeatherWind getWind() {
		return wind;
	}

	public void setWind(WeatherWind wind) {
		this.wind = wind;
	}

	public WeatherTemperature getMain() {
		return main;
	}

	public void setMain(WeatherTemperature main) {
		this.main = main;
	}
}
