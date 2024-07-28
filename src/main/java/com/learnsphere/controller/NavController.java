package com.learnsphere.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class NavController {

	@GetMapping("/")
	public String index() {
		return "index";
	}

//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	@GetMapping("/register")
	public String registermap() {
		return "register";
	}
	@GetMapping("/reset")
	public String resetmap() {
		return"resetpassword";
	}
	@GetMapping("/newpassword")
	public String newpasswordmap() {
		return"newpassword";
	}
	
	@GetMapping("/addLesson")
	public String addLessonmap() {
		return"addLesson";
	}
	@GetMapping("/createCourse")
	public String createCoursemap() {
		return"createcourse";
	}
	
	@GetMapping("/trainerHome")
	public String trainerHomemap() {
		return"trainerHome";
	}
//	@GetMapping("/studentHome")
//	public String studentHomemap() {
//		return"studentHome";
//	}

	@GetMapping("/myCourses")
	public String myCourse()
	{
		return "myCourses";
	}
	@GetMapping("/demoLesson")
	public String demoLesson()
	{
		return "demoLesson";
	}
	
	@PostMapping("/myCourses")
	public String myCourserazorpay()
	{
		return "myCourses";
	}
}
