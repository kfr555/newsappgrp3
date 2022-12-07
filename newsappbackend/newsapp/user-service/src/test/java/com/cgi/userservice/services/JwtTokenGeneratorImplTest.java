package com.cgi.userservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cgi.userservice.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtTokenGeneratorImpl.class})
@ExtendWith(SpringExtension.class)
class JwtTokenGeneratorImplTest {
    @Autowired
    private JwtTokenGeneratorImpl jwtTokenGeneratorImpl;

    /**
     * Method under test: {@link JwtTokenGeneratorImpl#generateToken(User)}
     */
    @Test
    void testGenerateToken() {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Kaneez");
        user.setLastName("Fathima");
        user.setPassword("ilikeyou");
        user.setUserId("42");
        Map<String, String> actualGenerateTokenResult = jwtTokenGeneratorImpl.generateToken(user);
        assertEquals(2, actualGenerateTokenResult.size());
        assertEquals("User successfully logged in", actualGenerateTokenResult.get("message"));
    }

    /**
     * Method under test: {@link JwtTokenGeneratorImpl#generateToken(User)}
     */
    @Test
    void testGenerateToken2() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();

        User user = new User("42", "Jane", "Doe", "iloveyou",
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Vyshnavi");
        user.setLastName("Bussa");
        user.setPassword("ilikeyou");
        user.setUserId("42");
        Map<String, String> actualGenerateTokenResult = jwtTokenGeneratorImpl.generateToken(user);
        assertEquals(2, actualGenerateTokenResult.size());
        assertEquals("User successfully logged in", actualGenerateTokenResult.get("message"));
    }

    /**
     * Method under test: {@link JwtTokenGeneratorImpl#generateToken(User)}
     */
    @Test
    void testGenerateToken3() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn("42");
        doNothing().when(user).setCreatedDate((Date) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setUserId((String) any());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Kavitha");
        user.setLastName("Boda");
        user.setPassword("iloveyou");
        user.setUserId("42");
        Map<String, String> actualGenerateTokenResult = jwtTokenGeneratorImpl.generateToken(user);
        assertEquals(2, actualGenerateTokenResult.size());
        assertEquals("User successfully logged in", actualGenerateTokenResult.get("message"));
        verify(user).getUserId();
        verify(user).setCreatedDate((Date) any());
        verify(user).setFirstName((String) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setUserId((String) any());
    }

    /**
     * Method under test: {@link JwtTokenGeneratorImpl#generateToken(User)}
     */
    @Test
    void testGenerateToken4() {
        User user = mock(User.class);
        when(user.getUserId()).thenReturn("");
        doNothing().when(user).setCreatedDate((Date) any());
        doNothing().when(user).setFirstName((String) any());
        doNothing().when(user).setLastName((String) any());
        doNothing().when(user).setPassword((String) any());
        doNothing().when(user).setUserId((String) any());
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Varshitha");
        user.setLastName("Shivakumar");
        user.setPassword("iloveyou");
        user.setUserId("22");
        Map<String, String> actualGenerateTokenResult = jwtTokenGeneratorImpl.generateToken(user);
        assertEquals(2, actualGenerateTokenResult.size());
        assertEquals("User successfully logged in", actualGenerateTokenResult.get("message"));
        verify(user).getUserId();
        verify(user).setCreatedDate((Date) any());
        verify(user).setFirstName((String) any());
        verify(user).setLastName((String) any());
        verify(user).setPassword((String) any());
        verify(user).setUserId((String) any());
    }
}