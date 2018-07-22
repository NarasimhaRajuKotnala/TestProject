package com.airelogic.springbootmongodbexample.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.springbootmongodbexample.models.Bug;
import com.airelogic.springbootmongodbexample.services.BugService;

@RestController
@RequestMapping("/api/v1")
public class BugController {
	
	@Autowired
	private BugService bugService;
	
	
	@RequestMapping("/createBug")
	public String create(@RequestParam String title, 
			   			 @RequestParam String description, 
			   			 @RequestParam LocalDateTime timestamp, 
			   			 @RequestParam LocalDate dueDate, 
			   			 @RequestParam String assignedTo, 
			   			 @RequestParam String userId,
			   			 @RequestParam  String[] viewedBy, 
			   			 @RequestParam String[] watchers, 
			   			 @RequestParam String priority, 
			   			 @RequestParam String[] tags, 
			   			 @RequestParam String[] comments, 
			   			 @RequestParam String status) {
		Bug bug = bugService.create(title, 
				    description, 
				    timestamp, 
				    dueDate, 
				    assignedTo, 
				    userId,
				    viewedBy, 
				    watchers, 
				    priority, 
				    tags, 
				    comments, 
				    status);
		return bug.toString();
	}
	
	@GetMapping("/getAllBugs")
	public List<Bug> getAll(){
		return bugService.getAll();
	}
	
	@GetMapping("/getBug")
	public Bug getBug(@RequestParam String title) {
		return bugService.getByTitle(title);
	}
	
	@RequestMapping("/updateBugByUserId")
	public String updateBugByUserId(@RequestParam String title, 
			             @RequestParam String description, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam LocalDate dueDate, 
			             @RequestParam String assignedTo, 
			             @RequestParam String userId,
			             @RequestParam String[] viewedBy, 
			             @RequestParam String[] watchers, 
			             @RequestParam String priority, 
			             @RequestParam String[] tags, 
			             @RequestParam String[] comments, 
			             @RequestParam String status) {
		Bug bug = bugService.updateBugByUserId(title, description, timestamp, dueDate, assignedTo, userId,viewedBy, watchers, priority, tags, comments, status);
		return bug.toString();
	}
	
	@RequestMapping("/updateBugByTitle")
	public String updateBugByTitle(@RequestParam String title, 
			             @RequestParam String description, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam LocalDate dueDate, 
			             @RequestParam String assignedTo, 
			             @RequestParam String userId,
			             @RequestParam String[] viewedBy, 
			             @RequestParam String[] watchers, 
			             @RequestParam String priority, 
			             @RequestParam String[] tags, 
			             @RequestParam String[] comments, 
			             @RequestParam String status) {
		Bug bug = bugService.updateBugByTitle(title, description, timestamp, dueDate, assignedTo, userId,viewedBy, watchers, priority, tags, comments, status);
		return bug.toString();
	}
	
	@RequestMapping("/deleteBugByTitle")
	public String deleteBugByTitle(@RequestParam String title) {
		bugService.deleteBugByTitle(title);
		return "Deleted" + title;
	}
	
	@RequestMapping("/deleteBugByTUserId")
	public String deleteBugByUserId(@RequestParam String userId) {
		bugService.deleteBugByTitle(userId);
		return "Deleted" + userId;
	}
	
	@RequestMapping("/deleteAllBugs")
	public String deleteAll() {
		bugService.deleteAll();
		return "Deleted all records";
	}
	
	
	
}
