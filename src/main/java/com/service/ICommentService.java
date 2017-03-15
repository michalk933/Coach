package com.service;

import java.util.List;

import com.domain.Comment;

public interface ICommentService {
	
	List<Comment> findCommentCoach(long id_coach);
	boolean addComment(Comment comment);

}
