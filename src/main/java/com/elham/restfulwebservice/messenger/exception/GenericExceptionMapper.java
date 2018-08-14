package com.elham.restfulwebservice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.elham.restfulwebservice.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
			   .entity(new ErrorMessage("internal server error",500,"www.elham.com"))
			   .build();
	}

}
