package com.messenger.exception;

/**
 * <p>
 *     Exception occurs, when specific user not found in the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 * @see com.messenger.exception.CustomException
 */
public class UserNotFoundException extends CustomException {

    /**
     * <p>
     *    Constructs an {@link UserNotFoundException}, when user not found in the database.
     * </p>
     *
     * @param exception occurs when user not found in the database
     */
    public UserNotFoundException(final String exception) {
        super(exception);
    }
}