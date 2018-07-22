package com.airelogic.springbootmongodbexample.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.springbootmongodbexample.models.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	public User findByUserName(String userName);
	public User findByFirstName(String firstName);
	
}
