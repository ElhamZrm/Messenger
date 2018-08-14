package com.elham.restfulwebservice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.elham.restfulwebservice.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		return Response.status(Status.NOT_FOUND)
				.entity(new ErrorMessage(exception.getMessage() , 404 , "com.elham.www"))
				.build();
	}

}
