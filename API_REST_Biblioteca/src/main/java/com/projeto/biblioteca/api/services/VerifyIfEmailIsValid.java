package com.projeto.biblioteca.api.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VerifyIfEmailIsValid implements ConstraintValidator<CheckIfEmailIsValid, String> {

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		String emailRegex = "@(hotmail|gmail)\\.com$";
		Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(email);
		return matcher.find();
	}
}
