package com.projeto.biblioteca.api.services;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = VerifyIfEmailIsValid.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckIfEmailIsValid {

	String message() default "Email invalido";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
