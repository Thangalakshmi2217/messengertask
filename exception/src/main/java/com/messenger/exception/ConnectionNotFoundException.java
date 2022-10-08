package com.messenger.exception;

/**
 * <p>
 *     Exception occurs, when it is failed to connect to the database.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 * @see com.messenger.exception.CustomException
 */
public class ConnectionNotFoundException extends CustomException {

    /**
     * <p>
     *    Constructs a {@link ConnectionNotFoundException}, when it is failed to connect to the database
     * </p>
     *
     * @param exception occurs when it is failed to get the connection
     */
    public ConnectionNotFoundException(final String exception) {
        super(exception);
    }
}