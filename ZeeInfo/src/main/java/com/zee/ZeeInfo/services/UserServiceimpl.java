package com.zee.ZeeInfo.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zee.ZeeInfo.model.*;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.zee.ZeeInfo.dao;
import com.zee.ZeeInfo.dao.UserDao;
import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserDto;

@Transactional
@Service(value = "userService")
public class UserServiceimpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
	
	@Override
	public void delete(int id) {
		userDao.deleteById(id);
		
	}

	@Override
	public User findOne(String firstname) {
		return userDao.findByfirstname(firstname);
	}
	
	@Override
	public User findById(int id) {
		Optional<User> optionalUser = userDao.findById(id);
		return optionalUser.isPresent()? optionalUser.get() : null;
	}
	
	@Override
	public UserDto update(UserDto userDto) {
		User user = findById(userDto.getId());
		if(user != null)
		{
			
			BeanUtils.copyProperties(userDto, user, "","");
			userDao.save(user);
		}
		return userDto;
	}
	
	@Override
	public User save(UserDto user) {
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setFirstname(user.getFirstname());
		newUser.setLastname(user.getLastname());
		newUser.setPassword(user.getPassword());
		newUser.setAge(user.getAge());
		newUser.setSalary(user.getSalary());
		
		
		return userDao.save(newUser);
		
		
	}

	
}
