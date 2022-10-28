package com.messenger.exception;

/**
 * <p>
 *     Exception occurs, when user details already existed in the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 * @see com.messenger.exception.CustomException
 */
public class UsernameAlreadyExistsException extends CustomException {

    /**
     * <p>
     *    Constructs an {@link UsernameAlreadyExistsException} when user details already existed in the database.
     * </p>
     *
     * @param exception occurs when user details already existed in the database
     */
    public UsernameAlreadyExistsException(final String exception) {
        super(exception);
    }
}