package com.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.entity.Lesson;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}
