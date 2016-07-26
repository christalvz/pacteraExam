package com.pactera.exam.model;

import org.springframework.stereotype.Component;
 
public class WeatherWind {
	Double speed;
	Double deg;
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Double getDeg() {
		return deg;
	}
	public void setDeg(Double deg) {
		this.deg = deg;
	}
}
