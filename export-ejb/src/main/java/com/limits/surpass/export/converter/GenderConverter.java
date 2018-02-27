package com.limits.surpass.export.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.limits.surpass.export.model.Gender;

/**
 * Convertidor de genero a short
 * @author german
 *
 */
@Converter
public class GenderConverter implements AttributeConverter<Gender, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Gender gender) {
		return Gender.MALE.equals(gender) ? 0 : 1;
	}

	@Override
	public Gender convertToEntityAttribute(Integer value) {
		return value > 0 ? Gender.FEMALE : Gender.MALE;
	}

}
