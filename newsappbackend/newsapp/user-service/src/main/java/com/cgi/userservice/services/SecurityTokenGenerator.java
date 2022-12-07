package com.cgi.userservice.services;

import java.util.Map;

import com.cgi.userservice.model.User;
import com.cgi.userservice.model.UserLogin;

public interface SecurityTokenGenerator {
	Map<String, String> generateToken(User user);

}
