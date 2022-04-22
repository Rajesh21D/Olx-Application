package com.zensar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.User;
import com.zensar.service.OlxLoginService;



@RestController
@RequestMapping(value="/user",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, consumes= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
public class MyController {
	
	
	@Autowired
	private OlxLoginService olxloginService;
	
	@GetMapping()
	public List<User> getAllUsers(@RequestHeader("userName") String username,@RequestHeader("password") String password) {
		
	return olxloginService.getAllUsers(username, password);	
	}
	
	@PostMapping()
	public User registerUser(@RequestBody User user) {
		
		return olxloginService.registerUser(user);
	}
	
	@DeleteMapping("/logout/{userId}")
	public boolean logoutUser(@PathVariable("userId") long id1,@RequestHeader("userName") String username,@RequestHeader("password") String password) {
		return olxloginService.logoutUser(id1, username, password);
		
	}
	@PostMapping("/authenticate")
	public String loginUser(@RequestBody User user ) {
		
		return olxloginService.loginUser(user);
		
	}
	

}
