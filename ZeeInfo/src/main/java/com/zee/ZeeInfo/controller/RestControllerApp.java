package com.zee.ZeeInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.ZeeInfo.model.ApiResponse;
import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserDto;
import com.zee.ZeeInfo.services.UserService;
@CrossOrigin(origins= "*", maxAge = 3600)
@RequestMapping("/users")
@RestController
public class RestControllerApp {

	// Get Mapping means just fetching the data
	// ResponseEntity converts java objects into json objects
	// ResponseEntity will produce the data
	
//	@GetMapping("/findzee")
//	public String fetchData() {
//		return "Welcome Zee infotech";
//	}
	@Autowired
	private UserService userService;
	
	@GetMapping("/fetchAll")
	public ApiResponse<List<User>> listUser() {
		return new ApiResponse<>(HttpStatus.OK.value(), "user saved successfully", userService.findAll());
	}
	
	@PostMapping("/create")
	public ApiResponse<User> saveUser(UserDto user) {
		return new ApiResponse<>(HttpStatus.OK.value(), "user saved successfully", userService.save(user));
	}
	
	@PutMapping("/update")
	public ApiResponse<UserDto> update(@RequestBody UserDto user) {
		ApiResponse<UserDto> obj = new ApiResponse<>(HttpStatus.OK.value(), "user updated successfully", userService.update(user));
		
		return obj;
	}
	
	@GetMapping("/{username}")
	public ApiResponse<User> getOne(@PathVariable String username){
		return new ApiResponse<>(HttpStatus.OK.value(), "User info obtained", userService.findOne(username));
	}
	
	@DeleteMapping("/{id}")
	public ApiResponse<Void> getOne(@PathVariable int  id){
		userService.delete(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "User deleted successfully", null);
}
}

