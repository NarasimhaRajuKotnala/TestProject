package com.airelogic.springbootmongodbexample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.springbootmongodbexample.models.User;
import com.airelogic.springbootmongodbexample.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//Create operation
	public User create(String firstName, String lastName,String userName,String password) {
		return userRepository.save(new User(firstName,lastName,userName,password));
	}
	
	//Retrieve operation
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User getByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public User getByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}
	
	public User update(String firstName, String lastName, String userName, String password) {
		User user = userRepository.findByUserName(userName);
		user.setLastName(lastName);
		user.setUserName(userName);
		user.setPassword(password);
		
		return userRepository.save(user);
	}
	
	//Delete operation
	public void deleteAll() {
		userRepository.deleteAll();
	}
	
	public void delete(String userName) {
		User user = userRepository.findByUserName(userName);
		userRepository.delete(user);
	}

}
