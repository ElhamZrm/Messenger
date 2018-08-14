package com.elham.restfulwebservice.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.elham.restfulwebservice.messenger.model.Message;
import com.elham.restfulwebservice.messenger.resources.beans.RestfulParamsBean;
import com.elham.restfulwebservice.messenger.services.MessageService;


@Path("messages")
public class MessageResources {
	
	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam RestfulParamsBean restfulparams){
		if(restfulparams.getYear()>0) {
			return messageService.getAllMessages(restfulparams.getYear());
		}
		if(restfulparams.getStart()>0 && restfulparams.getSize()>0) {
			return messageService.getAllMessages(restfulparams.getStart(),restfulparams.getSize());
		}
		
		return messageService.getAllMessages();
		
	}
	
	@GET
	@Path("context")
	@Produces(MediaType.TEXT_PLAIN)
	public String getContextParams(@Context UriInfo uriInfo, @Context HttpHeaders header) {
		return header.getRequestHeader("myheader").toString();
	}

	@Path("/{messageId}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Message msg , @Context UriInfo uriInfo) throws URISyntaxException {
//		return messageService.addMessage(msg);
		Message message = messageService.addMessage(msg);
		String path = uriInfo.getAbsolutePath().toString();
//		return Response.created(new URI(path+ "/" + message.getId())).entity(message).build();
		return Response.created(uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build())
			   .entity(message)
			   .build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@Path("{messageId}/comments")
	@Consumes(MediaType.APPLICATION_JSON)
	public CommentResources getComments() {
		return new CommentResources();
	}
	
	
	
	
	
}
