package com.mindbowser.validation;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<EmailValidation, String> {

	private String regExprEmail = "^[A-Za-z0-9._%+-]+@gmail\\.com$";

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (email.isBlank())
			return true;

		Pattern pat = Pattern.compile(regExprEmail);
		return pat.matcher(email).matches();
	}

	@Override
	public void initialize(EmailValidation constraintAnnotation) {

	}

}
