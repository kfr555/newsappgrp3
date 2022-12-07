package com.cgi.favouriteservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewsNotFoundExceptionTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link NewsNotFoundException#NewsNotFoundException(String)}
     *   <li>{@link NewsNotFoundException#setMessage(String)}
     *   <li>{@link NewsNotFoundException#toString()}
     *   <li>{@link NewsNotFoundException#getMessage()}
     * </ul>
     */
    @Test
    void testConstructor() {
        NewsNotFoundException actualNewsNotFoundException = new NewsNotFoundException("An error occurred");
        actualNewsNotFoundException.setMessage("An error occurred");
        String actualToStringResult = actualNewsNotFoundException.toString();
        assertEquals("An error occurred", actualNewsNotFoundException.getMessage());
        assertEquals("NewsNotFoundException [message=An error occurred]", actualToStringResult);
    }
}

