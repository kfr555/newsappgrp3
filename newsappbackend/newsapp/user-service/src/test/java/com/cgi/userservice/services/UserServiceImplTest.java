package com.cgi.userservice.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cgi.userservice.exception.UserAlreadyExistsException;
import com.cgi.userservice.exception.UserNotFoundException;
import com.cgi.userservice.model.User;
import com.cgi.userservice.repository.UserRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Method under test: {@link UserServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser() throws UserAlreadyExistsException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Varshitha");
        user.setLastName("Shivakumar");
        user.setPassword("iloveyou");
        user.setUserId("22");

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setFirstName("Kaneez");
        user1.setLastName("Fathima");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        Optional<User> ofResult = Optional.of(user1);
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((String) any())).thenReturn(ofResult);

        User user2 = new User();
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user2.setCreatedDate(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        user2.setFirstName("Kavitha");
        user2.setLastName("Boda");
        user2.setPassword("iloveyou");
        user2.setUserId("42");
        assertThrows(UserAlreadyExistsException.class, () -> userServiceImpl.saveUser(user2));
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#saveUser(User)}
     */
    @Test
    void testSaveUser2() throws UserAlreadyExistsException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Neha");
        user.setLastName("Mohan");
        user.setPassword("iloveyou");
        user.setUserId("42");
        when(userRepository.save((User) any())).thenReturn(user);
        when(userRepository.findById((String) any())).thenReturn(Optional.empty());

        User user1 = new User();
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        user1.setCreatedDate(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        user1.setFirstName("Vyshnavi");
        user1.setLastName("Bussa");
        user1.setPassword("iloveyou");
        user1.setUserId("42");
        assertTrue(userServiceImpl.saveUser(user1));
        verify(userRepository).save((User) any());
        verify(userRepository).findById((String) any());
    }

    /**
     * Method under test: {@link UserServiceImpl#findByUserIdAndPassword(String, String)}
     */
    @Test
    void testFindByUserIdAndPassword() throws UserNotFoundException {
        User user = new User();
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        user.setCreatedDate(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        user.setFirstName("Chaitra");
        user.setLastName("Shivakumar");
        user.setPassword("iloveyou");
        user.setUserId("42");
        when(userRepository.findByUserIdAndPassword((String) any(), (String) any())).thenReturn(user);
        assertSame(user, userServiceImpl.findByUserIdAndPassword("42", "iloveyou"));
        verify(userRepository).findByUserIdAndPassword((String) any(), (String) any());
    }
}