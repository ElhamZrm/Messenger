package com.elham.restfulwebservice.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.elham.restfulwebservice.messenger.services.CommentService;
import com.elham.restfulwebservice.messenger.model.Comment;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResources {
	
	CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@GET
	@Path("{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId ) {
		return commentService.getComment(messageId, commentId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId , Comment comment) {
		return commentService.addComment(messageId, comment);
	}

}
