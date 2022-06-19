package com.zee.ZeeInfo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.ZeeInfo.Dto.UserRequest;
import com.zee.ZeeInfo.dao.UserValidatorRepository;
import com.zee.ZeeInfo.exception.UserNotFoundException;
import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserDto;
import com.zee.ZeeInfo.model.UserValidator;

@Service
public class UservalidatorServiceImpl implements UserValidatorService {
	
	@Autowired
	private UserValidatorRepository userval;

	@Override
	public UserValidator save(UserRequest userRequest) {
		//UserValidator userValidator = UserValidator.
				//build(0, userRequest.getName(), userRequest.getEmail(),userRequest.getMobile(),
				//userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
				
				UserValidator uv = new UserValidator();
				uv.setAge(userRequest.getAge());
				uv.setEmail(userRequest.getEmail());
				uv.setGender(userRequest.getGender());
				uv.setName(userRequest.getName());
				uv.setNationality(userRequest.getNationality());
				uv.setMobile(userRequest.getMobile());
				
				return userval.save(uv);
	}

	@Override
	public UserValidator findById(int id) {
		Optional<UserValidator> optionalUser = userval.findById(id);
		return optionalUser.isPresent()? optionalUser.get() : null;
	}
	
	
	// To Check if the user id is not found then we will throw the exception and execution will stop
	public UserValidator getUser(int id) throws UserNotFoundException {
		UserValidator user = userval.findByUserId(id);
		if(user != null) {
			return user;
		}
		else {
			throw new UserNotFoundException("user not found");
		}
	}	
}
