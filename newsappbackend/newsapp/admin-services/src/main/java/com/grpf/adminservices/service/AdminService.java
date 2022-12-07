package com.grpf.adminservices.service;

import com.grpf.adminservices.exception.NewsNotFoundException;
import com.grpf.adminservices.exception.UserNameAlreadyExistsException;
import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.model.News;
import com.grpf.adminservices.repository.AdminRepository;
import com.grpf.adminservices.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	@Autowired
	NewsRepository newsRepository;
	
	public AdminRegister registerAdminDetails(AdminRegister adminRegister) {
		return adminRepository.save(adminRegister);
	}
	
	public String checkForUserName(AdminRegister adminRegister) throws UserNameAlreadyExistsException {
		Optional<AdminRegister> existingUser = Optional.ofNullable(adminRepository.findByUserName(adminRegister.getUserName()));
		try{
		if(existingUser.isPresent())
			throw new UserNameAlreadyExistsException("User Name Exists");
		return null;
		} catch (Exception e){
			return "User Name Exists";
		}
	}

	public String checkForEmailId(AdminRegister adminRegister) {
		Optional<AdminRegister> existingUser = Optional.ofNullable(adminRepository.findByEmailId(adminRegister.getEmailId()));
		if(existingUser.isPresent()) 
			return "EmailId Exists";
		return null;
	}

	public News addNews(News news) {
		 return newsRepository.save(news);
		
	}

	public String deleteNews(Integer id) throws NewsNotFoundException {
		Optional<News> existingNews = newsRepository.findById(id);
		System.out.println(existingNews);
		try{
		if(existingNews.isPresent()) {
			newsRepository.delete(existingNews.get());
			return "News deleted successfully";
		}
		throw new NewsNotFoundException("News not Exists");
		}catch(Exception e){
			return "News not Exists";
		}
	}

	public List<News> getAllNews() {
		
		return newsRepository.findAll();
	}
		
}
	
	



	
	


