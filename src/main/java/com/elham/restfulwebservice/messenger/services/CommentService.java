package com.elham.restfulwebservice.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.elham.restfulwebservice.messenger.model.Message;
import com.elham.restfulwebservice.messenger.model.Comment;

public class CommentService {
	private Map<Long , Message> messages = DatabaseClass.getMessages();
	
	public List<Comment> getAllComments(long messageId){
		Map<Long , Comment> comments = messages.get(messageId).getComments();
		return new ArrayList(comments.values());	
	}
	
	public Comment getComment(Long messageId , Long commentId) {
		return messages.get(messageId).getComments().get(commentId);
	}

	public Comment addComment(long messageId , Comment comment) {
		Map<Long , Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId , Comment comment) {
		if(comment.getId()<=0) {
			return null;	
		}
		Map<Long,Comment> comments = messages.get(messageId).getComments();	
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(commentId);
	}
}
