package com.learnsphere.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnsphere.entity.LearnSphereUsers;
import com.learnsphere.entity.Lesson;
import com.learnsphere.repository.LessonRepository;

@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	LessonRepository lessonrepo;

	@Override
	public Lesson getLesson(int lessonId) {
		
		return lessonrepo.findById(lessonId).get();
	}


	
	
}
