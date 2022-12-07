package com.grpf.adminservices.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.repository.AdminRepository;


@Service
public class AdminUserDetailsService implements UserDetailsService {

	
	@Autowired
	private AdminRepository  adminRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("userName"+username);
		AdminRegister adminRegister = adminRepository.findByUserName(username);
		return new User(adminRegister.getUserName(),adminRegister.getPassword(),new ArrayList<>());
	}

}
