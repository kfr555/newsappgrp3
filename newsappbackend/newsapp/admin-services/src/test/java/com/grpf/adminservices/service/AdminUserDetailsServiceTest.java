package com.grpf.adminservices.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.repository.AdminRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdminUserDetailsService.class})
@ExtendWith(SpringExtension.class)
class AdminUserDetailsServiceTest {
    @MockBean
    private AdminRepository adminRepository;

    @Autowired
    private AdminUserDetailsService adminUserDetailsService;

    /**
     * Method under test: {@link AdminUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        AdminRegister adminRegister = new AdminRegister();
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminRepository.findByUserName((String) any())).thenReturn(adminRegister);
        UserDetails actualLoadUserByUsernameResult = adminUserDetailsService.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(adminRepository).findByUserName((String) any());
    }

    /**
     * Method under test: {@link AdminUserDetailsService#loadUserByUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: Cannot pass null or empty values to constructor
        //       at com.grpf.adminservices.service.AdminUserDetailsService.loadUserByUsername(AdminUserDetailsService.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        AdminRegister adminRegister = mock(AdminRegister.class);
        when(adminRegister.getPassword()).thenReturn("iloveyou");
        when(adminRegister.getUserName()).thenReturn("");
        doNothing().when(adminRegister).setAdminId(anyInt());
        doNothing().when(adminRegister).setEmailId((String) any());
        doNothing().when(adminRegister).setPassword((String) any());
        doNothing().when(adminRegister).setUserName((String) any());
        adminRegister.setAdminId(123);
        adminRegister.setEmailId("42");
        adminRegister.setPassword("iloveyou");
        adminRegister.setUserName("janedoe");
        when(adminRepository.findByUserName((String) any())).thenReturn(adminRegister);
        adminUserDetailsService.loadUserByUsername("janedoe");
    }
}

