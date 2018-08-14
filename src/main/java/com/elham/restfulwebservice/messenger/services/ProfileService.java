package com.elham.restfulwebservice.messenger.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.elham.restfulwebservice.messenger.model.Profile;

public class ProfileService {

	
	Map<String , Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Elham", new Profile(1l , "ELham" , "Zr"));
		profiles.put("Dave", new Profile(2l , "Dave" , "Zr"));
		
	}
	
	
	public List<Profile> getAllProfile(){
		return new ArrayList(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		return profiles.put(profile.getProfileName() , profile);
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty())
			return null;
		else
			profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public void removeProfile(String profileName) {
		profiles.remove(profileName);
	}
}
