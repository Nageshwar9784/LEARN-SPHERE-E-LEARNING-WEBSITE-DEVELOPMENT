package com.learnsphere.service;


import java.util.List;

import com.learnsphere.entity.Comments;

public interface CommentService {

	Comments SaveComment(Comments comm);

	List<Comments> getAllComments();

}
