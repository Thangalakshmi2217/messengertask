package com.messenger.validation;

import java.util.Set;

import jakarta.validation.Validator;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;

import org.hibernate.validator.HibernateValidator;

/**
 * <p>
 *     Validates the details.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class UserDetailValidation {

    /**
     * <p>
     *     Validates the user details.
     * </p>
     *
     * @param objectDetail represents the user details
     * @param validation   refers the validation group
     * @param <T>          the type of the class modeled by the class object
     * @return when the information is correct, returns valid; or else returns the violation message
     */
    public static <T> String validateDetails(final Object objectDetail, final Class<T> validation) {
        String validationMessage = null;

        try (final ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure().buildValidatorFactory()) {
            final Validator validator = validatorFactory.getValidator();
            final Set<ConstraintViolation<Object>> constraintViolations = validator.validate(objectDetail, validation);

            if (constraintViolations.size() > 0) {

                for (ConstraintViolation<Object> violation : constraintViolations) {
                    validationMessage = violation.getMessage();
                }
            } else {
                validationMessage = "valid";
            }
        }
        return validationMessage;
    }
}