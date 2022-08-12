package com.mindtree.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mindtree.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>{

	
	@Query(value="select count(*) from college",nativeQuery = true)
	int noOfColleges();
	
	
	College findById(int id);
	
	@Query(value="select total_students from college where id=:id",nativeQuery = true)
	int NoOfStudents(@Param("id") int id);
	
	
	
	
}
