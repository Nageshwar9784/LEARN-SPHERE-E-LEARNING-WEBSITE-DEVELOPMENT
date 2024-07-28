package com.learnsphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnsphere.entity.LearnSphereUsers;
import com.learnsphere.repository.LearnSphereRepository;
import com.learnsphere.service.LearnSphereService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private LearnSphereRepository userRepository;
	@Autowired
	LearnSphereService lservice;
    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login view name
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam("email") String email, @RequestParam("password") String password,
                              HttpSession session,RedirectAttributes res) {
        // Validate the username and password
        
    	if(lservice.checkEmail(email)==true) {
    		LearnSphereUsers user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            // Set the authenticated user in the session
            session.setAttribute("user", user);
			if(lservice.validRole(email).equals("Trainer")) {
				res.addFlashAttribute("success", "login successfully");
				return "redirect:/trainerHome";
			}else {
		res.addFlashAttribute("success", "login successfully");
		return "redirect:/studentHome";
				}
            // Redirect to the user's learning section
        } else {
			res.addFlashAttribute("error", "wrong password");
			return "redirect:/login"; // Return the login view with an error message
        }
    	}
		else {
			res.addFlashAttribute("error", "data not found");
			
			return "redirect:/login";
		}
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidate the session and remove the authenticated user
        session.invalidate();
        return "redirect:/login"; // Redirect to the login page
    }
}

