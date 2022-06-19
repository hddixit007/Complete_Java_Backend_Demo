package com.zee.ZeeInfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.ZeeInfo.model.User;
import com.zee.ZeeInfo.model.UserValidator;

@Repository
public interface UserValidatorRepository extends JpaRepository<UserValidator, Integer> {

	UserValidator findByUserId(int id);
	
	
	
}
