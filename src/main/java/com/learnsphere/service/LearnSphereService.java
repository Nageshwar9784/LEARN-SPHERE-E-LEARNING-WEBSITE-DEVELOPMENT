package com.learnsphere.service;



import com.learnsphere.entity.ContactUs;
import com.learnsphere.entity.LearnSphereUsers;

public interface LearnSphereService {
	//add new user in database
	public String addLearnSphereUsers(LearnSphereUsers user);
	
	//checks email is already present in database
	public boolean checkEmail(String email);

	public boolean loginUser(String email, String password);

	public Object setPassword(String email, String password);

	public Object validRole(String email);

	public String addContactus(ContactUs contact);
	
	
	


}
