package com.messenger.conversation.model;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>
 *     An annotation for person name validation.
 * </p>
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = {NameValidation.class})
public @interface PersonName {
    String message() default "{personName should have at least 3 character}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}