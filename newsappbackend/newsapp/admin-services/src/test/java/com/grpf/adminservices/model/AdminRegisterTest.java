package com.grpf.adminservices.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdminRegisterTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AdminRegister#AdminRegister()}
     *   <li>{@link AdminRegister#setAdminId(int)}
     *   <li>{@link AdminRegister#setEmailId(String)}
     *   <li>{@link AdminRegister#setPassword(String)}
     *   <li>{@link AdminRegister#setUserName(String)}
     *   <li>{@link AdminRegister#toString()}
     *   <li>{@link AdminRegister#getAdminId()}
     *   <li>{@link AdminRegister#getEmailId()}
     *   <li>{@link AdminRegister#getPassword()}
     *   <li>{@link AdminRegister#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        AdminRegister actualAdminRegister = new AdminRegister();
        actualAdminRegister.setAdminId(123);
        actualAdminRegister.setEmailId("42");
        actualAdminRegister.setPassword("iloveyou");
        actualAdminRegister.setUserName("janedoe");
        String actualToStringResult = actualAdminRegister.toString();
        assertEquals(123, actualAdminRegister.getAdminId());
        assertEquals("42", actualAdminRegister.getEmailId());
        assertEquals("iloveyou", actualAdminRegister.getPassword());
        assertEquals("janedoe", actualAdminRegister.getUserName());
        assertEquals("AdminRegister [adminId=123, userName=janedoe, emailId=42, password=iloveyou]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link AdminRegister#AdminRegister(int, String, String, String)}
     *   <li>{@link AdminRegister#setAdminId(int)}
     *   <li>{@link AdminRegister#setEmailId(String)}
     *   <li>{@link AdminRegister#setPassword(String)}
     *   <li>{@link AdminRegister#setUserName(String)}
     *   <li>{@link AdminRegister#toString()}
     *   <li>{@link AdminRegister#getAdminId()}
     *   <li>{@link AdminRegister#getEmailId()}
     *   <li>{@link AdminRegister#getPassword()}
     *   <li>{@link AdminRegister#getUserName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        AdminRegister actualAdminRegister = new AdminRegister(123, "janedoe", "42", "iloveyou");
        actualAdminRegister.setAdminId(123);
        actualAdminRegister.setEmailId("42");
        actualAdminRegister.setPassword("iloveyou");
        actualAdminRegister.setUserName("janedoe");
        String actualToStringResult = actualAdminRegister.toString();
        assertEquals(123, actualAdminRegister.getAdminId());
        assertEquals("42", actualAdminRegister.getEmailId());
        assertEquals("iloveyou", actualAdminRegister.getPassword());
        assertEquals("janedoe", actualAdminRegister.getUserName());
        assertEquals("AdminRegister [adminId=123, userName=janedoe, emailId=42, password=iloveyou]",
                actualToStringResult);
    }
}

