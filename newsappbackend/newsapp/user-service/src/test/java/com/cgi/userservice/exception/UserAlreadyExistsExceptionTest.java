package com.cgi.userservice.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class UserAlreadyExistsExceptionTest {
    /**
     * Method under test: {@link UserAlreadyExistsException#UserAlreadyExistsException(String)}
     */
    @Test
    void testConstructor() {
        UserAlreadyExistsException actualUserAlreadyExistsException = new UserAlreadyExistsException("An error occurred");
        assertNull(actualUserAlreadyExistsException.getCause());
        assertEquals(0, actualUserAlreadyExistsException.getSuppressed().length);
        assertEquals("An error occurred", actualUserAlreadyExistsException.getMessage());
        assertEquals("An error occurred", actualUserAlreadyExistsException.getLocalizedMessage());
    }
}

