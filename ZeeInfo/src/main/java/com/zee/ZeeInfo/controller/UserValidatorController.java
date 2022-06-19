package com.zee.ZeeInfo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.ZeeInfo.Dto.UserRequest;
import com.zee.ZeeInfo.model.ApiResponse;
import com.zee.ZeeInfo.model.UserValidator;
import com.zee.ZeeInfo.services.UserValidatorService;
@RestController
@RequestMapping("/userVa")
public class UserValidatorController {
	
	@Autowired
	private UserValidatorService service;
	
	@PostMapping("/signup")
	public ResponseEntity<UserValidator> saveUser(@RequestBody @Valid UserRequest userRequest) {
		return new ResponseEntity<>(service.save(userRequest), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ApiResponse<UserValidator> getData(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(), "User info obtained", service.findOne(id));
	}

}
