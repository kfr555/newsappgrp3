package com.grpf.adminservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdminLoginTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AdminLogin#AdminLogin()}
     *   <li>{@link AdminLogin#setPassword(String)}
     *   <li>{@link AdminLogin#setUserName(String)}
     *   <li>{@link AdminLogin#getPassword()}
     *   <li>{@link AdminLogin#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AdminLogin actualAdminLogin = new AdminLogin();
        actualAdminLogin.setPassword("iloveyou");
        actualAdminLogin.setUserName("janedoe");
        assertEquals("iloveyou", actualAdminLogin.getPassword());
        assertEquals("janedoe", actualAdminLogin.getUserName());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AdminLogin#AdminLogin(String, String)}
     *   <li>{@link AdminLogin#setPassword(String)}
     *   <li>{@link AdminLogin#setUserName(String)}
     *   <li>{@link AdminLogin#getPassword()}
     *   <li>{@link AdminLogin#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AdminLogin actualAdminLogin = new AdminLogin("janedoe", "iloveyou");
        actualAdminLogin.setPassword("iloveyou");
        actualAdminLogin.setUserName("janedoe");
        assertEquals("iloveyou", actualAdminLogin.getPassword());
        assertEquals("janedoe", actualAdminLogin.getUserName());
    }
}

