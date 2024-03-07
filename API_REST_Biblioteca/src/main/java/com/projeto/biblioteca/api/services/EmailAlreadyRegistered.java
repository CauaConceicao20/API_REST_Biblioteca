package com.projeto.biblioteca.api.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Constraint(validatedBy = EmailValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailAlreadyRegistered  {
	
String message() default "Email Já Cadastrado antes";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
