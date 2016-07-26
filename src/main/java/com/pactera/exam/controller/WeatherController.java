package com.pactera.exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pactera.exam.model.City;
import com.pactera.exam.model.WeatherDetails;
import com.pactera.exam.service.WeatherService;

@Controller
@RequestMapping("/weather")
public class WeatherController {
	private WeatherService weatherService = new WeatherService();

	@RequestMapping(method = RequestMethod.GET)
	public String init(@ModelAttribute("cityForm") City city, ModelMap model) {
		model.remove("weatherDetails");
		model.addAttribute("city", new City());
		model.addAttribute("cityList", weatherService.getCityMap());
		if(city != null || !city.getCity().equals(" ")){
			model.addAttribute("weatherDetails", weatherService.getWeatherDetails(city));
		}
		return "index";
	}
	
	@RequestMapping(value="/result", method = RequestMethod.GET)
	public String onSubmit(@ModelAttribute("cityForm") City city, ModelMap model) {
		model.remove("weatherDetails");
		model.addAttribute("city", new City());
		model.addAttribute("cityList", weatherService.getCityMap());
		if(city != null || !city.getCity().equals(" ")){
			model.addAttribute("weatherDetails", weatherService.getWeatherDetails(city));
		}
		return "result";
	}

}
