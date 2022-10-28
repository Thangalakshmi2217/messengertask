package com.messenger.authentication.model;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>
 *     An annotation for password validation.
 * </P>
 */
@Retention(RUNTIME)
@Constraint(validatedBy = {PasswordValidation.class})
public @interface Password {

    String message() default "{Password should have at least one capital Letter, One Small Letter,one Special Character}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}