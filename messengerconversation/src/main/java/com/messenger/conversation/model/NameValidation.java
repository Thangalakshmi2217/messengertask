package com.messenger.conversation.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * <p>
 *     Examines the constraints and validates the username.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 */
public class NameValidation implements ConstraintValidator<PersonName, String> {

    /**
     * <p>
     *    Validates the username and checks whether it matches the pattern.
     * </p>
     * <p>When each of the following conditions is met, a username is deemed to be legitimate:</p>
     * <li>1.Initial of the name should be in the uppercase (A-Z) english letters.</li>
     * <li>2.Uppercase (A-Z) and lowercase (a-z) english letters</li>
     * <li>3.Name can contain white space characters</li>
     * <li>4.Name can contain special character like(_)</li>
     * <li>5.Name should contain three to forty characters.</li>
     * <p>Example: Twozo_technologies</p>
     *
     * @param personName validates the name of the user
     * @param context    context in which the constraint is evaluated
     * @return true when username matches the pattern
     */
    @Override
    public boolean isValid(final String personName, final ConstraintValidatorContext context) {
        return personName.matches("(^[a-zA-Z_]{3,40}$)");
    }
}