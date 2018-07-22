package com.airelogic.springbootmongodbexample.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.springbootmongodbexample.models.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
	
	public Comment findByUserId(String userId);
	public Comment findByBugId(String bugId); 
}
