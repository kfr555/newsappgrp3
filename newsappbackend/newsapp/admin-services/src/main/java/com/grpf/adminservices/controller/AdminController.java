package com.grpf.adminservices.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.grpf.adminservices.exception.NewsNotFoundException;
import com.grpf.adminservices.exception.UserNameAlreadyExistsException;
import com.grpf.adminservices.model.AdminLogin;
import com.grpf.adminservices.model.AdminRegister;
import com.grpf.adminservices.model.FavoriteNews;
import com.grpf.adminservices.model.News;
import com.grpf.adminservices.model.User;
import com.grpf.adminservices.service.AdminService;
import com.grpf.adminservices.util.JwtUtil;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	/**
	 * This class takes Admin details such as 
	 * userName, password ,emailId 
	 * @param adminRegister admin details object
	 * @return registered details of admin
	 */
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AdminRegister adminRegister) throws UserNameAlreadyExistsException {
		String userNameStatus = adminService.checkForUserName(adminRegister);
		if(userNameStatus == null) {
			String emailIdStatus = adminService.checkForEmailId(adminRegister);
			if(emailIdStatus == null)
				return new ResponseEntity(adminService.registerAdminDetails(adminRegister),HttpStatus.OK);
			
			return new ResponseEntity<>(Collections.singletonMap("Error", "Email already exists"),HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(Collections.singletonMap("Error", "User already exists"),HttpStatus.CONFLICT);
	}
	
	
	
	@GetMapping(path="msg")
	public String message() {
		return "Welcome to Admin Dashboard";
	}
	
	
	/**
	 * Takes userName and password from the user 
	 * and make authentication
	 * @param adminLogin admin login details object
	 * @return "Invalid credentials" if admin is not registered
	 */
	@PutMapping("/login")
	public ResponseEntity<?> login(@RequestBody AdminLogin adminLogin) {
		try {
			System.out.println(adminLogin);
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(adminLogin.getUserName(),adminLogin.getPassword()));
		} catch(Exception ex) {
			System.out.println(ex.toString());
			return new ResponseEntity<>(Collections.singletonMap("Error", "Invalid Credentials"),HttpStatus.NOT_FOUND);
		}
		
		String token =  jwtUtil.generateToken(adminLogin.getUserName());
		return new ResponseEntity<>(Collections.singletonMap("Jwt token", token),HttpStatus.OK);

	}

	/**
	 * this function save news into the database
	 * @param news object which contains news
	 * @return news which is saved into the database
	 */
	
	@PostMapping("/saveNews")
	public News addNews(@RequestBody News news) {
		return adminService.addNews(news);
		
	}
	
	/**
	 * this function fetch all the news present in
	 * the database
	 * @return list of all the news present in the database
	 */
	@GetMapping("/news")
	public List<News> getAllNews(){
		return adminService.getAllNews();
	}
	
	
	/**
	 * delete the news based on the author name
	 * @param author takes author name as input param
	 * @return delete status 
	 */
	@DeleteMapping("/deleteNews")
	public ResponseEntity<?> deleteNewsById(@RequestParam Integer id) throws  NewsNotFoundException {
		return new ResponseEntity<>(Collections.singletonMap("status", adminService.deleteNews(id)),HttpStatus.ACCEPTED) ;
		
	}
	
	@GetMapping("/users")
	public List<User> getUsersIds() {
		String url = "http://localhost:8085/api/v1/userservice/users";
		 ResponseEntity<User[]> responseEntity = 
				    restTemplate.getForEntity(url, User[].class);
		 User[] userArray = responseEntity.getBody();
		 return Arrays.stream(userArray).collect(Collectors.toList());
	}
	
	@GetMapping("/userFavNews")
	public List<FavoriteNews> getFavNewsByUserId(@RequestParam String userId){
		
		String url = "http://localhost:8082/api/v1/favservice/News/" + userId;
		 ResponseEntity<FavoriteNews[]> responseEntity = 
				    restTemplate.getForEntity(url, FavoriteNews[].class);
		 FavoriteNews[] favNewsArray = responseEntity.getBody();
		 return Arrays.stream(favNewsArray).collect(Collectors.toList());
	}
	
	
	

}
