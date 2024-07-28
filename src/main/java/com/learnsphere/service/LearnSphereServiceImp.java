package com.learnsphere.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.learnsphere.entity.ContactUs;
import com.learnsphere.entity.LearnSphereUsers;
import com.learnsphere.repository.ContactUsRepo;
import com.learnsphere.repository.LearnSphereRepository;
@Service
public class LearnSphereServiceImp implements LearnSphereService {
	@Autowired
	LearnSphereRepository lsrepo;
	@Autowired
	ContactUsRepo crepo;

	public String addLearnSphereUsers(LearnSphereUsers user) {
		lsrepo.save(user);
		return "Student added Successfully";
	}
	public boolean checkEmail(String email) {

		return lsrepo.existsByEmail(email);
	}
	@Override
	public boolean loginUser(String email, String password) {
		// TODO Auto-generated method 
		LearnSphereUsers user=lsrepo.getByEmail(email);
		if(user.getPassword().equals(password)) {
			return true;	
		}
		else {
			return false;
		}
	}
	@Override
	public Object setPassword(String email, String password) {
		LearnSphereUsers findByEmail = lsrepo.getByEmail(email);
		findByEmail.setPassword(password);
		lsrepo.save(findByEmail);
		return findByEmail;
	}
	public Object validRole(String email) {
		String getrole = lsrepo.getByEmail(email).getRole();
		return getrole;
	}
	@Override
	public String addContactus(ContactUs contact) {
		 crepo.save(contact);
		
		return "contact successfully added";
	}
	 

	    public LearnSphereUsers getLearningSectionByEmail(LearnSphereUsers user) {
	        // Fetch the learning section associated with the user
	        return lsrepo.findByEmail(user.getEmail());
	    }
	

}
