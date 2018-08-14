package com.elham.restfulwebservice.messenger.resources;

import javax.ws.rs.Consumes;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.elham.restfulwebservice.messenger.exception.ProfileException;
import com.elham.restfulwebservice.messenger.model.Profile;
import com.elham.restfulwebservice.messenger.services.ProfileService;

@Path("profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getAllProfiels(){
		return profileService.getAllProfile();
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName") String profileName) {
		if(profileName.equals("restricted"))
			throw new ProfileException("this profile is "+profileName);
		return profileService.getProfile(profileName);
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName") String profileName , Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void removeProfile(@PathParam("profileName") String profileName ) {
		profileService.removeProfile(profileName);
	}
}
