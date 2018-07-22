package com.airelogic.springbootmongodbexample.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.springbootmongodbexample.models.History;
import com.airelogic.springbootmongodbexample.repositories.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepository;
	
	
	//Create operation
	public History create(String bugId, String userId, String action, LocalDateTime timestamp) {
		return historyRepository.save(new History(bugId, userId, action,timestamp));
	}
	
	//Retrieve operation
	public List<History> getAll(){
		return historyRepository.findAll();
	}
	
	public History getByUserId(String userId) {
		return historyRepository.findByUserId(userId);
	}
	
	public History getByBugId(String bugId) {
		return historyRepository.findByBugId(bugId);
	}
	
	public History updateByBugId(String bugId, String userId, String action, LocalDateTime timestamp) {
		
		History history = historyRepository.findByBugId(bugId);
				history.setUserId(userId);
				history.setAction(action);
		return historyRepository.save(history);
	}
	
	public History updateByUserId(String bugId, String userId, String action, LocalDateTime timestamp) {
		
		History history = historyRepository.findByUserId(userId);
				history.setBugId(bugId);
				history.setAction(action);
		return historyRepository.save(history);
	}
	
	//Delete operation
	public void deleteAll() {
		historyRepository.deleteAll();
	}
	
	//delete user by BugId
	public void deleteByBugId(String bugId) {
		History history = historyRepository.findByBugId(bugId);
		historyRepository.delete(history);
	}
	
	//delete user by UserId
	public void deleteByUserId(String userId) {
		History history = historyRepository.findByUserId(userId);
		historyRepository.delete(history);
	}


}
