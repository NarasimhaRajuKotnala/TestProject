package com.airelogic.springbootmongodbexample.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.springbootmongodbexample.models.History;
import com.airelogic.springbootmongodbexample.services.HistoryService;

@RestController
@RequestMapping("/api/v1")
public class HistoryController {
	
	@Autowired
	private HistoryService historyService;
	
	
	@RequestMapping("/createHistory")
	public String create(@RequestParam String bugId, 
			             @RequestParam String userId, 
			             @RequestParam String action,
			             @RequestParam LocalDateTime timestamp) {
		History history = historyService.create(bugId,userId,action,timestamp);
		return history.toString();
	}
	
	@GetMapping("/getAllHistory")
	public List<History> getAll(){
		return historyService.getAll();
	}
	
	@GetMapping("/getHistoryByUserId")
	public History getHistoryByUserId(@RequestParam String userId) {
		return historyService.getByUserId(userId);
	}
	
	
	@GetMapping("/getHistoryByBugId")
	public History getHistoryByBugId(@RequestParam String bugId) {
		return historyService.getByBugId(bugId);
	}
	
	
	@RequestMapping("/updateHistoryByUserId")
	public String updateByUserId(@RequestParam String bugId, 
			             @RequestParam String body, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam String userId) {
		History history = historyService.updateByUserId(bugId, body, userId, timestamp);
		return history.toString();
	}
	
	
	@RequestMapping("/updateHistoryByBugId")
	public String updateByBugId(@RequestParam String bugId, 
			             @RequestParam String body, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam String userId) {
		History history = historyService.updateByBugId(bugId, body, userId, timestamp);
		return history.toString();
	}
	
	@RequestMapping("/deleteByBugId")
	public String deleteByBugId(@RequestParam String bugId) {
		historyService.deleteByBugId(bugId);
		return "Deleted history for Bug : " + bugId;
	}
	
	@RequestMapping("/deleteAllHistory")
	public String deleteAll() {
		historyService.deleteAll();
		return "Deleted all records";
	}
	
	
	
}
