package com.grpf.adminservices.config;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.grpf.adminservices.filter.JwtFilter;
import com.grpf.adminservices.service.AdminUserDetailsService;

import java.util.HashMap;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.cache.NullUserCache;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.accept.ContentNegotiationStrategy;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {SecurityConfiguration.class, AuthenticationConfiguration.class})
@ExtendWith(SpringExtension.class)
class SecurityConfigurationTest {
    @MockBean
    private AdminUserDetailsService adminUserDetailsService;

    @Autowired
    private ApplicationContext applicationContext;

    @MockBean
    private AuthenticationTrustResolver authenticationTrustResolver;

    @MockBean
    private ContentNegotiationStrategy contentNegotiationStrategy;

    @MockBean
    private JwtFilter jwtFilter;

    @Autowired
    private ObjectPostProcessor<Object> objectPostProcessor;

    @Autowired
    private SecurityConfiguration securityConfiguration;

    /**
     * Method under test: {@link SecurityConfiguration#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        securityConfiguration.configure(authenticationManagerBuilder);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).getUserCache() instanceof NullUserCache);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isHideUserNotFoundExceptions());
        assertFalse(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link SecurityConfiguration#configure(AuthenticationManagerBuilder)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder.userDetailsService(org.springframework.security.core.userdetails.UserDetailsService)" because "auth" is null
        //       at com.grpf.adminservices.config.SecurityConfiguration.configure(SecurityConfiguration.java:36)
        //   See https://diff.blue/R013 to resolve this issue.

        securityConfiguration.configure((AuthenticationManagerBuilder) null);
    }

    /**
     * Method under test: {@link SecurityConfiguration#configure(AuthenticationManagerBuilder)}
     */
    @Test
    void testConfigure3() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        authenticationManagerBuilder
                .authenticationEventPublisher(new DefaultAuthenticationEventPublisher(mock(ApplicationEventPublisher.class)));
        securityConfiguration.configure(authenticationManagerBuilder);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).getUserCache() instanceof NullUserCache);
        assertTrue(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isHideUserNotFoundExceptions());
        assertFalse(
                ((DaoAuthenticationProvider) ((ProviderManager) authenticationManagerBuilder.getOrBuild()).getProviders()
                        .get(0)).isForcePrincipalAsString());
    }

    /**
     * Method under test: {@link SecurityConfiguration#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure4() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.context.ApplicationContext.getBeanNamesForType(java.lang.Class)" because "context" is null
        //       at com.grpf.adminservices.config.SecurityConfiguration.configure(SecurityConfiguration.java:43)
        //   See https://diff.blue/R013 to resolve this issue.

        AuthenticationManagerBuilder authenticationBuilder = new AuthenticationManagerBuilder(objectPostProcessor);
        securityConfiguration.configure(new HttpSecurity(objectPostProcessor, authenticationBuilder, new HashMap<>()));
    }

    /**
     * Method under test: {@link SecurityConfiguration#configure(HttpSecurity)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConfigure5() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "org.springframework.security.config.annotation.web.builders.HttpSecurity.csrf()" because "http" is null
        //       at com.grpf.adminservices.config.SecurityConfiguration.configure(SecurityConfiguration.java:42)
        //   See https://diff.blue/R013 to resolve this issue.

        securityConfiguration.configure((HttpSecurity) null);
    }

    /**
     * Method under test: {@link SecurityConfiguration#authenticationManager()}
     */
    @Test
    void testAuthenticationManager() throws Exception {
        assertTrue(securityConfiguration.authenticationManager() instanceof ProviderManager);
    }

    /**
     * Method under test: {@link SecurityConfiguration#passwordEncoder()}
     */
    @Test
    void testPasswordEncoder() {
        assertTrue(securityConfiguration.passwordEncoder() instanceof NoOpPasswordEncoder);
    }
}

