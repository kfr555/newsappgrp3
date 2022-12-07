package com.cgi.userservice.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class UserTest {
  
    @Test
    void testConstructor() {
        User actualUser = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualUser.setCreatedDate(fromResult);
        actualUser.setFirstName("Varshitha");
        actualUser.setLastName("Shivakumar");
        actualUser.setPassword("iloveyou");
        actualUser.setUserId("22");
        assertSame(fromResult, actualUser.getCreatedDate());
        assertEquals("Varshitha", actualUser.getFirstName());
        assertEquals("Shivakumar", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("22", actualUser.getUserId());
    }

 
    @Test
    void testConstructor2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        User actualUser = new User("22", "Varsha", "Shivakumar", "iloveyou",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualUser.setCreatedDate(fromResult);
        actualUser.setFirstName("Varsha");
        actualUser.setLastName("Shivakumar");
        actualUser.setPassword("iloveyou");
        actualUser.setUserId("22");
        assertSame(fromResult, actualUser.getCreatedDate());
        assertEquals("Varsha", actualUser.getFirstName());
        assertEquals("Shivakumar", actualUser.getLastName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertEquals("22", actualUser.getUserId());
    }
}