package com.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	boolean existsById(int courseId);
}
