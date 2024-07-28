package com.learnsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learnsphere.entity.LearnSphereUsers;

@Repository
public interface LearnSphereRepository extends JpaRepository<LearnSphereUsers, Integer> {

	boolean existsByEmail(String email);
	LearnSphereUsers getByEmail(String email);
	LearnSphereUsers findByEmail(String email);
	
	

}
