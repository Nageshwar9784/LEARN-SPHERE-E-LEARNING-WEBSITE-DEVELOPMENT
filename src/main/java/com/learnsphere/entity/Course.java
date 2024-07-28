package com.learnsphere.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Course {
	@Id
	int courseId;
	String coureseName;
	int coursePrice;
	@OneToMany
	List<Lesson> lessons;
	public Course(int courseId, String coureseName, int coursePrice, List<Lesson> lessons) {
		super();
		this.courseId = courseId;
		this.coureseName= coureseName;
		this.coursePrice = coursePrice;
		this.lessons = lessons;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCoureseName() {
		return coureseName;
	}
	public void setCoureseName(String coureseName) {
		this.coureseName = coureseName;
	}
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", coureseName=" + coureseName + ", coursePrice=" + coursePrice
				+ ", lessons=" + lessons + "]";
	}


}
