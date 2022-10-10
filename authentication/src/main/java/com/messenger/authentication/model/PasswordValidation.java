package com.messenger.authentication.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 *     Validates the password.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 * @see jakarta.validation.ConstraintValidator
 */
public class PasswordValidation implements ConstraintValidator<Password, String> {

    /**
     * <p>
     *     Validating the {@link Password}.
     * </p>
     * <p>A password is considered valid when the following constraints are satisfied:</p>
     * <lI>At least one upper case english letter [A-Z]</li>
     * <li>At least one lower case english letter [a-z]</li>
     * <li>At least one digit [0-9]</li>
     * <li>At least one special character [#?!@$%^&*-]</li>
     * <li>Minimum 6 characters and can have 20 characters.</li>
     *
     * @param password {@link Password} is validated
     * @param context  context in which the constraint is evaluated
     * @return true when the password matches the given pattern
     */
    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        return password.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=])(?=\\S+$).{6,20}");
    }
}
