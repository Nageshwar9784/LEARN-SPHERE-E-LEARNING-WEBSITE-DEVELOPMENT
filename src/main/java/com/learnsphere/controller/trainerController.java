package com.learnsphere.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import com.learnsphere.entity.Course;
import com.learnsphere.entity.Lesson;
import com.learnsphere.service.TrainerService;

@Controller
public class trainerController {
	@Autowired
	TrainerService tservice;
	@PostMapping("/addCourse")
	public String addCourse(@RequestParam("courseId") int courseId,@RequestParam("coureseName") String coureseName,@RequestParam("coursePrice") int coursePrice, RedirectAttributes res) {
		
		if(tservice.checkCourse(courseId)==false) {
			Course course = new Course();
			
			course.setCoureseName(coureseName);
			course.setCourseId(courseId);
			course.setCoursePrice(coursePrice);
			tservice.addCourse(course);
			res.addFlashAttribute("success",coureseName+" Course Added Successfully");
			return "redirect:/trainerHome";
		}
		else {
			res.addFlashAttribute("success","Course Already Exits");
			return "redirect:/createCourse";
		}
		
	}
	@PostMapping("/addLesson")
	public String addLesson(@RequestParam("courseId") int courseId,@RequestParam("lessonId") int lessonId,@RequestParam("lessonName")String lessonName,@RequestParam("topics")String topics,@RequestParam("link")String link,RedirectAttributes res) {
		try {
			Course course=tservice.getCourse(courseId);
			Lesson lesson = new Lesson(lessonId, lessonName, topics, link, course);
			
			course.getLessons().add(lesson);
			tservice.addLesson(lesson);
			res.addFlashAttribute("success", "Lesson with Lesson id {"+lessonId+"}is added successfully");
			return "redirect:/trainerHome";
		}catch(Exception e) {
			res.addFlashAttribute("error", "Course with course id {"+courseId+"}not present");
			return "redirect:/addLesson";
		}
	}
	@GetMapping("/showcourse")
	public String courseTrainermap(Model model) {
		List<Course> list=tservice.getAllCourses();
		//System.out.println(list);
		model.addAttribute("course", list);
		return "course";
	}
	@GetMapping("/purcheaseCourse")
	public String buycourse(Model model) {
		List<Course> list=tservice.getAllCourses();
		//System.out.println(list);
		model.addAttribute("course", list);
		return "/purcheaseCourse";
	}
	
	
	
}
