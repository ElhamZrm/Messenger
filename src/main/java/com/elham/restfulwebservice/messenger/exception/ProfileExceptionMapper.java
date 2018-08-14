package com.elham.restfulwebservice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import com.elham.restfulwebservice.messenger.model.ErrorMessage;

public class ProfileExceptionMapper implements ExceptionMapper<ProfileException>{

	@Override
	public Response toResponse(ProfileException exception) {
		return Response.status(Status.FORBIDDEN)
				.entity(new ErrorMessage(exception.getMessage(), 403, "www.elham.com"))
				.build();
	}

}
