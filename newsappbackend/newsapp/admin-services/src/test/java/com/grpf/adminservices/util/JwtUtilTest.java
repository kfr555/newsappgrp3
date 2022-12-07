package com.grpf.adminservices.util;

import io.jsonwebtoken.Claims;

import java.util.ArrayList;

import java.util.function.Function;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JwtUtil.class})
@ExtendWith(SpringExtension.class)
class JwtUtilTest {
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * Method under test: {@link JwtUtil#extractUsername(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExtractUsername() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.grpf.adminservices.util.JwtUtil.extractAllClaims(JwtUtil.java:35)
        //       at com.grpf.adminservices.util.JwtUtil.extractClaim(JwtUtil.java:31)
        //       at com.grpf.adminservices.util.JwtUtil.extractUsername(JwtUtil.java:23)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtUtil.extractUsername("ABC123");
    }

    /**
     * Method under test: {@link JwtUtil#extractExpiration(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExtractExpiration() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.grpf.adminservices.util.JwtUtil.extractAllClaims(JwtUtil.java:35)
        //       at com.grpf.adminservices.util.JwtUtil.extractClaim(JwtUtil.java:31)
        //       at com.grpf.adminservices.util.JwtUtil.extractExpiration(JwtUtil.java:27)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtUtil.extractExpiration("ABC123");
    }

    /**
     * Method under test: {@link JwtUtil#extractClaim(String, Function)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testExtractClaim() {
        // TODO: Complete this test.
        //   Reason: R005 Unable to load class.
        //   Class: reactor.netty.http.server.HttpServer
        //   Please check that the class is available on your test runtime classpath.
        //   See https://diff.blue/R005 to resolve this issue.

        // Arrange
        // TODO: Populate arranged inputs
        JwtUtil jwtUtil = this.jwtUtil;
        String token = "";
        Function<Claims, Object> claimsResolver = null;

        // Act
        Object actualExtractClaimResult = jwtUtil.extractClaim(token, claimsResolver);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link JwtUtil#generateToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        jwtUtil.generateToken("janedoe");
    }

    /**
     * Method under test: {@link JwtUtil#generateToken(String)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGenerateToken2() {
        // TODO: Complete this test.
        //   Reason: R031 Method may be time-sensitive.
        //   Diffblue Cover was only able to write tests which were time-sensitive.
        //   The assertions no longer passed when run at an alternate date, time and
        //   timezone. Try refactoring the method to take a java.time.Clock instance so
        //   that the time can be parameterized during testing.
        //   Please see https://diff.blue/R031

        jwtUtil.generateToken("Username");
    }

    /**
     * Method under test: {@link JwtUtil#validateToken(String, UserDetails)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testValidateToken() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   io.jsonwebtoken.MalformedJwtException: JWT strings must contain exactly 2 period characters. Found: 0
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:235)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parse(DefaultJwtParser.java:481)
        //       at io.jsonwebtoken.impl.DefaultJwtParser.parseClaimsJws(DefaultJwtParser.java:541)
        //       at com.grpf.adminservices.util.JwtUtil.extractAllClaims(JwtUtil.java:35)
        //       at com.grpf.adminservices.util.JwtUtil.extractClaim(JwtUtil.java:31)
        //       at com.grpf.adminservices.util.JwtUtil.extractUsername(JwtUtil.java:23)
        //       at com.grpf.adminservices.util.JwtUtil.validateToken(JwtUtil.java:55)
        //   See https://diff.blue/R013 to resolve this issue.

        jwtUtil.validateToken("ABC123", new User("janedoe", "iloveyou", new ArrayList<>()));
    }
}

