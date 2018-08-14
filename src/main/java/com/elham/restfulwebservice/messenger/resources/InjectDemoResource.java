package com.elham.restfulwebservice.messenger.resources;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elham.restfulwebservice.messenger.resources.beans.RestfulParamsBean;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    @GET
    public String getIt(@MatrixParam("matrixparam") String value,
    					@HeaderParam("myheader") String header,
    					@CookieParam("mycookie") String cookie) {
    	
    	return "matrix param is : " + value + " header is : "+header + " cookie is : "+cookie;
    }
    
    @GET
    @Path("beanfilter")
    public String getParams(@BeanParam RestfulParamsBean restfulBean) {
    	return "matrixParam is: "+ restfulBean.getMyMatrix();
    }
}
