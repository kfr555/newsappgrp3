package com.grpf.adminservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grpf.adminservices.model.AdminLogin;
import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.model.News;


@Repository
public interface AdminRepository extends JpaRepository<AdminRegister, Integer>{
	
	AdminRegister findByUserName(String userName);
	
	AdminRegister findByEmailId(String emailId);
	
}
