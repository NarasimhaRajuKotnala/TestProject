package com.airelogic.springbootmongodbexample.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.springbootmongodbexample.models.Bug;

public interface BugRepository extends MongoRepository<Bug, String> {
	
	
	public Bug findByUserId(String userId);
	public Bug findByTitle(String title);
	
	
	

}
