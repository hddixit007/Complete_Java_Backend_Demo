package com.zee.ZeeInfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "User_Tbl")
public class UserValidator {
	
	@Id
	@GeneratedValue
	private int userId;
	
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String mobile;
	@Column
	private String gender;
	@Column
	private int age;
	@Column
	private String nationality;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public UserValidator() {
		
		super();
	}
	
	
	
	

}
