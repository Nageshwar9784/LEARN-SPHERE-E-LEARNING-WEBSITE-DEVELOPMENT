package com.learnsphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learnsphere.entity.Comments;
import com.learnsphere.entity.LearnSphereUsers;
import com.learnsphere.entity.Lesson;
import com.learnsphere.service.CommentService;
import com.learnsphere.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentservice;
	
	@Autowired
	CommentService commentService;
	@PostMapping("/gotolesson")
	public String myLesson(@RequestParam("lessonId")int lessonId,Model m,RedirectAttributes res) {
		try {
			Lesson lesson=studentservice.getLesson(lessonId);
			//System.out.println(lesson);
			m.addAttribute("LessonList", lesson);
			
			return "myLesson";
		}catch (Exception e) {
			res.addFlashAttribute("error", "Lesson not present");
			return "redirect:/demoLesson";
		}
	}
	
	@PostMapping("/addComment")
	public String comments(@RequestParam ("comment")String comment,Model m) {
	Comments comm=new Comments();
	comm.setComment(comment);
	commentService.SaveComment(comm);
	
	List<Comments> list=commentService.getAllComments();
	m.addAttribute("list",list);
	return "myLesson";
	}
	
	 @GetMapping("/studentHome")
	    public String myLearningSection(HttpSession session, Model model) {
	        LearnSphereUsers user = (LearnSphereUsers) session.getAttribute("email");
	       // LearningSection learningSection = studentservice.getLearningSectionByUser(user);
	            //model.addAttribute("learningSection", learningSection);
	            return "studentHome"; // Return the "My Learning" view name
	    }
}
