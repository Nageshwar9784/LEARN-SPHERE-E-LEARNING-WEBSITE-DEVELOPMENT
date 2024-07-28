package com.learnsphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.entity.Comments;
import com.learnsphere.repository.CommentsRepository;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentsRepository commentRepo;

	@Override
	public Comments SaveComment(Comments comm) {
		
		return commentRepo.save(comm);
	}

	@Override
	public List<Comments> getAllComments() {
		return commentRepo.findAll();	
	}
	
}
