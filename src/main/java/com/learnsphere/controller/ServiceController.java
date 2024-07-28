package com.learnsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.learnsphere.entity.LearnSphereUsers;
import com.learnsphere.entity.ContactUs;
import com.learnsphere.service.LearnSphereService;
@Controller
public class ServiceController {
	@Autowired
	LearnSphereService lservice;
	@PostMapping("/adduser")
	public String register(@RequestParam ("firstName") String firstName,@RequestParam ("lastName") String lastName,@RequestParam ("email") String email,@RequestParam ("password") String password,@RequestParam ("role") String role,@RequestParam ("mobileNo") String mobileNo ) {
		
		
		if(lservice.checkEmail(email)==false) {
			LearnSphereUsers user = new LearnSphereUsers(firstName, lastName, email,password, role, mobileNo);
			lservice.addLearnSphereUsers(user);
			return "redirect:/login";
		}
		else {
			System.out.println(" user email already exists");
			return "redirect:/register";
		}

	}
/*	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email,@RequestParam ("password") String password,RedirectAttributes res) {
		if(lservice.checkEmail(email)==true) {
			boolean user=lservice.loginUser(email,password);
			if(user) {
					if(lservice.validRole(email).equals("Trainer")) {
						res.addFlashAttribute("success", "login successfully");
						return "redirect:/trainerHome";
					}else {
				res.addFlashAttribute("success", "login successfully");
				return "redirect:/studentHome";
						}
					}
					else {
				res.addFlashAttribute("error", "wrong password");
				return "redirect:/login";
					}
		}
		else {
			res.addFlashAttribute("error", "data not found");
			
			return "redirect:/login";
		}
	}
		
*/		
		@PostMapping("/checkemail")
		public String reset(@RequestParam("email") String email,RedirectAttributes res) {
			if(lservice.checkEmail(email)==true) {
				
				//res.addFlashAttribute("success", "password reset successfully");
				return "/newpassword";
			}
			else {
					res.addFlashAttribute("invalidEmail", "user doesn't exist register firstly");
				return "redirect:/register";
			}			
		}
		@PostMapping("/setpassword")
		public String setPassword(@RequestParam("password")String password,@RequestParam("email") String email,RedirectAttributes res) {
			
			if(lservice.checkEmail(email)==true) {
			lservice.setPassword(email,password);
			res.addFlashAttribute("success", "password reset successfully");
			return "redirect:/login";
			}
			else {
				res.addFlashAttribute("error", "Email doesn't exist please Enter correct Email id");
				return "redirect:/newpassword";
			}
			
		}
		@PostMapping("/contact")
		public String contactmap(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("msg") String msg) {
			ContactUs contact=new ContactUs(name,email,msg);
			lservice.addContactus(contact);
			return "redirect:/";
		}
		
		

		
		
	
}
