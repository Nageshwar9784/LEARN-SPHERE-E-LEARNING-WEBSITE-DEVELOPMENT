package com.learnsphere.service;

import java.util.List;

import com.learnsphere.entity.Course;
import com.learnsphere.entity.Lesson;

public interface TrainerService {
	
	public boolean checkCourse(int courseId);
	public String addCourse(Course course) ;
	public Course getCourse(int courseId);
	public String addLesson(Lesson lesson);
	public List<Course> getAllCourses();
}
