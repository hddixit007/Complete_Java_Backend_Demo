package com.zee.ZeeInfo.services;
import java.util.List;

import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserDto;


public interface UserService {
	
	User save(UserDto user);
	
	List<User> findAll();
	
	void delete(int id);
	
	User findOne(String username);
	
	User findById (int id);
	
	UserDto update(UserDto userDto);
}
