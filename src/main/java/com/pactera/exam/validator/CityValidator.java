package com.pactera.exam.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pactera.exam.model.City;

@Component
public class CityValidator implements Validator {

	public boolean supports(Class<?> object) {
		return City.class.isAssignableFrom(object);
	}

	public void validate(Object object, Errors errors) {
		City city = (City) object;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "required.city");

		if ("NONE".equals(city.getCity())) {
			errors.rejectValue("city", "required.city");
		}

	}

}
