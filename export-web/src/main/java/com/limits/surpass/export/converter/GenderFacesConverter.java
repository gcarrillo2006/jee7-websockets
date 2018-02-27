package com.limits.surpass.export.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.limits.surpass.export.model.Gender;

@FacesConverter(value="genderConverter")
public class GenderFacesConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return value == "Hombre" ? Gender.MALE : Gender.FEMALE;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		return value == Gender.MALE ? "Hombre" : "Mujer";
	}

}
