package com.airelogic.springbootmongodbexample.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airelogic.springbootmongodbexample.models.Bug;
import com.airelogic.springbootmongodbexample.repositories.BugRepository;

@Service
public class BugService {
	
	@Autowired
	private BugRepository bugRepository;
	
	
	//Create operation
	public Bug create(String title, String description,LocalDateTime timestamp,LocalDate dueDate, String assignedTo, String userId,
			String[] viewedBy, String[] watchers, String priority, String[] tags, String[] comments, String status) {
		return bugRepository.save(new Bug(title,description, timestamp,  dueDate,  assignedTo,  userId,
				 viewedBy, watchers,  priority,  tags, comments,  status));
	}
	
	//Retrieve operation
	public List<Bug> getAll(){
		return bugRepository.findAll();
	}
	
	public Bug getByUserId(String userId) {
		return bugRepository.findByUserId(userId);
	}
	
	public Bug getByTitle(String title) {
		return bugRepository.findByTitle(title);
	}
	
	//Update bug by UserId
	public Bug updateBugByUserId(String title, String description,LocalDateTime timestamp,LocalDate dueDate, String assignedTo, String userId,
			String[] viewedBy, String[] watchers, String priority, String[] tags, String[] comments, String status) {
		Bug bug = bugRepository.findByUserId(userId);
		bug.setDescription(description);
		bug.setTimestamp(timestamp);
		bug.setDueDate(dueDate);
		bug.setAssignedTo(assignedTo);
		bug.setUserId(userId);
		bug.setViewedBy(viewedBy);
		bug.setWatchers(watchers);
		bug.setPriority(priority);
		bug.setTags(tags);
		bug.setComments(comments);
		bug.setStatus(status);
		
		return bugRepository.save(bug);
	}


	
	//Update bug by Title
	public Bug updateBugByTitle(String title, String description,LocalDateTime timestamp,LocalDate dueDate, String assignedTo, String userId,
			String[] viewedBy, String[] watchers, String priority, String[] tags, String[] comments, String status) {
		Bug bug = bugRepository.findByTitle(title);
		bug.setDescription(description);
		bug.setTimestamp(timestamp);
		bug.setDueDate(dueDate);
		bug.setAssignedTo(assignedTo);
		bug.setUserId(userId);
		bug.setViewedBy(viewedBy);
		bug.setWatchers(watchers);
		bug.setPriority(priority);
		bug.setTags(tags);
		bug.setComments(comments);
		bug.setStatus(status);
		
		return bugRepository.save(bug);
	}
	
	
	
	
	//Delete operation
	public void deleteAll() {
		bugRepository.deleteAll();
	}
	
	//delete bug by Title
	public void deleteBugByTitle(String title) {
		Bug user = bugRepository.findByTitle(title);
		bugRepository.delete(user);
	}
	
	//delete bug by UserId
	public void deleteBugByUserId(String userId) {
		Bug user = bugRepository.findByUserId(userId);
		bugRepository.delete(user);
	}


}
