package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.Comment;
import com.repository.CommentRepository;

@Service
public class CommentService implements ICommentService {

	private CommentRepository commentRepository;
	
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}


	public List<Comment> findCommentCoach(long id_coach) {
		return commentRepository.findComent(id_coach);
	}


	public boolean addComment(Comment comment) {
		return commentRepository.addComent(comment);
	}
	
	

}
