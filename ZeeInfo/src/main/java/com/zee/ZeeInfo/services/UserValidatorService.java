package com.zee.ZeeInfo.services;

import java.util.List;

import com.zee.ZeeInfo.Dto.UserRequest;
import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserValidator;

public interface UserValidatorService {
	
	UserValidator save(UserRequest userRequest);
	
	UserValidator findById(int id);
	
	
}
