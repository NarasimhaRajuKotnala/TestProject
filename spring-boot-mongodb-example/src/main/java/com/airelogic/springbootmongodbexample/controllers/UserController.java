package com.airelogic.springbootmongodbexample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.springbootmongodbexample.models.User;
import com.airelogic.springbootmongodbexample.services.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("createUser")
	public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, @RequestParam String password) {
		User user = userService.create(firstName, lastName, userName, password);
		return user.toString();
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAll(){
		return userService.getAll();
	}
	
	@GetMapping("/getUserByUserName")
	public User getUserByUserName(@RequestParam String userName) {
		return userService.getByUserName(userName);
	}
	
	@GetMapping("/getUserByFirstName")
	public User getUserByFirstName(@RequestParam String firstName) {
		return userService.getByFirstName(firstName);
	}
	
	@RequestMapping("/updateUser")
	public String updateUserByUserName(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String userName, @RequestParam String password ) {
		User user = userService.update(firstName, lastName, userName, password);
		return user.toString();
	}
	
	@RequestMapping("/deleteUser")
	public String delete(@RequestParam String userName) {
		userService.delete(userName);
		return "Deleted" + userName;
	}
	
	@RequestMapping("/deleteAllUsers")
	public String deleteAll() {
		userService.deleteAll();
		return "Deleted all records";
	}
	
	
	
}
