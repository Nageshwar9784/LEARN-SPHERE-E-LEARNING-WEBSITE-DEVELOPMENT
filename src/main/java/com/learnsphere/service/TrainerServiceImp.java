package com.learnsphere.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.entity.Course;
import com.learnsphere.entity.Lesson;
import com.learnsphere.repository.CourseRepository;
import com.learnsphere.repository.LessonRepository;
@Service
public class TrainerServiceImp implements TrainerService {
	
	@Autowired
	CourseRepository courserepo;
	@Autowired
	LessonRepository lessonrepo;
	public String addCourse(Course course) {
		courserepo.save(course);
		return "Course added successfully";
	}
	
	
	public boolean checkCourse(int courseId) {
		return courserepo.existsById(courseId);
		
		
	}

	@Override
	public Course getCourse(int courseId) {
		return courserepo.findById(courseId).get();
		
	}


	@Override
	public String addLesson(Lesson lesson) {
		lessonrepo.save(lesson);
		return "Lesson added Sucefully";
	}


	@Override
	public List<Course> getAllCourses() {
		return courserepo.findAll();
	
	}

}
