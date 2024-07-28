package com.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.entity.ContactUs;

@Repository
public interface ContactUsRepo extends JpaRepository<ContactUs, Integer> {
	
}
