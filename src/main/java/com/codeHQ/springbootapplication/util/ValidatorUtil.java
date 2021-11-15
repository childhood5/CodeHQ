package com.codeHQ.springbootapplication.util;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.codeHQ.springbootapplication.exception.InvalidDeviceIdException;
import com.codeHQ.springbootapplication.exception.InvalidLatitudeException;
import com.codeHQ.springbootapplication.exception.InvalidLongitudeException;

/**
 * Validation class
 * 
 *
 */
public final class ValidatorUtil {

	private ValidatorUtil() {
		// Default constructor.
	}

	/**
	 * Binding the field to occur error
	 * 
	 * @param result
	 */
	public static void validateRequest(BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> errors = result.getFieldErrors();
			errors.forEach(error -> {
				String fieldName = error.getField();
				switch (fieldName) {
					case "deviceId":
						throw new InvalidDeviceIdException();
					case "latitude":
						throw new InvalidLatitudeException();
					case "longitude":
						throw new InvalidLongitudeException();
					default:
						break;
				}
			});
		}
	}

}
