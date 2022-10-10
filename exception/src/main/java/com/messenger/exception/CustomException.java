package com.messenger.exception;

/**
 * <p>
 *     Exception occurs, when we create our own exception.
 * </p>
 *
 * @author Venkatesh N
 * @version 1.0
 * @see java.lang.RuntimeException
 */
public class CustomException extends RuntimeException {

    /**
     * <p>
     *    Constructs a {@link CustomException}.
     * </p>
     *
     * @param exception a message occurs when an exception is thrown
     */
    public CustomException(final String exception) {
        super(exception);
    }
}