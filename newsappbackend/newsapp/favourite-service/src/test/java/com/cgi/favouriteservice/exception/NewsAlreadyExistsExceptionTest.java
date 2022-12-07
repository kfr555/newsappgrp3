package com.cgi.favouriteservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewsAlreadyExistsExceptionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NewsAlreadyExistsException#NewsAlreadyExistsException(String)}
     *   <li>{@link NewsAlreadyExistsException#setMessage(String)}
     *   <li>{@link NewsAlreadyExistsException#toString()}
     *   <li>{@link NewsAlreadyExistsException#getMessage()}
     * </ul>
     */
    @Test
    void testConstructor() {
        NewsAlreadyExistsException actualNewsAlreadyExistsException = new NewsAlreadyExistsException("An error occurred");
        actualNewsAlreadyExistsException.setMessage("An error occurred");
        String actualToStringResult = actualNewsAlreadyExistsException.toString();
        assertEquals("An error occurred", actualNewsAlreadyExistsException.getMessage());
        assertEquals("NewsAlreadyExistsException [message=An error occurred]", actualToStringResult);
    }
}

