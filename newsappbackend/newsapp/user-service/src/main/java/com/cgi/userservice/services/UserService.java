package com.cgi.userservice.services;

import java.util.List;
import java.util.Optional;

import com.cgi.userservice.exception.UserAlreadyExistsException;
import com.cgi.userservice.exception.UserNotFoundException;
import com.cgi.userservice.model.User;
import com.cgi.userservice.model.UserLogin;

public interface UserService {

	boolean saveUser(User user) throws UserAlreadyExistsException;

	User findByUserIdAndPassword(String userId, String password) throws UserNotFoundException;

	List<User> getAllUsers();

	
	

	

}
