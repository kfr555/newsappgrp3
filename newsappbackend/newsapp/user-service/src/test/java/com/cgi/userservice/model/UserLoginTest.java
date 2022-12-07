package com.cgi.userservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UserLoginTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link UserLogin}
     *   <li>{@link UserLogin#setPassword(String)}
     *   <li>{@link UserLogin#setUserId(String)}
     *   <li>{@link UserLogin#toString()}
     *   <li>{@link UserLogin#getPassword()}
     *   <li>{@link UserLogin#getUserId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        UserLogin actualUserLogin = new UserLogin();
        actualUserLogin.setPassword("iloveyou");
        actualUserLogin.setUserId("42");
        String actualToStringResult = actualUserLogin.toString();
        assertEquals("iloveyou", actualUserLogin.getPassword());
        assertEquals("42", actualUserLogin.getUserId());
        assertEquals("UserLogin [userId=42, password=iloveyou]", actualToStringResult);
    }
}

