package com.airelogic.springbootmongodbexample.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.airelogic.springbootmongodbexample.models.Comment;
import com.airelogic.springbootmongodbexample.services.CommentService;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	
	@RequestMapping("/createComment")
	public String create(@RequestParam String bugId, 
			             @RequestParam String body, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam String userId) {
		Comment comment = commentService.create(bugId,body, timestamp,userId);
		return comment.toString();
	}
	
	@GetMapping("/getAllComments")
	public List<Comment> getAll(){
		return commentService.getAll();
	}
	
	@GetMapping("/getCommentByUserId")
	public Comment getCommentByUserId(@RequestParam String userId) {
		return commentService.getByUserId(userId);
	}
	
	
	@GetMapping("/getCommentByBugId")
	public Comment getCommentByBugId(@RequestParam String bugId) {
		return commentService.getByBugId(bugId);
	}
	
	
	@RequestMapping("/updateCommentByUserId")
	public String updateCommentByUserId(@RequestParam String bugId, 
			             @RequestParam String body, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam String userId) {
		Comment comment = commentService.updateCommentByUserId(bugId, body, timestamp, userId);
		return comment.toString();
	}
	
	@RequestMapping("/updateCommentByBugId")
	public String updateCommentByBugId(@RequestParam String bugId, 
			             @RequestParam String body, 
			             @RequestParam LocalDateTime timestamp, 
			             @RequestParam String userId) {
		Comment comment = commentService.updateCommentByBugId(bugId, body, timestamp, userId);
		return comment.toString();
	}
	
	
	@RequestMapping("/deleteCommentByBugId")
	public String delete(@RequestParam String bugId) {
		commentService.deleteCommentByBugId(bugId);
		return "Deleted Bug" + bugId;
	}
	
	@RequestMapping("/deleteAllComments")
	public String deleteAll() {
		commentService.deleteAll();
		return "Deleted all Comments";
	}
	
	
	
}
