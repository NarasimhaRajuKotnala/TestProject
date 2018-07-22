package com.airelogic.springbootmongodbexample.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.airelogic.springbootmongodbexample.models.History;

public interface HistoryRepository extends MongoRepository<History, String> {
	
	public History findByBugId(String bugId);
	public History findByUserId(String userId);
	public History findByAction(String action);

}
