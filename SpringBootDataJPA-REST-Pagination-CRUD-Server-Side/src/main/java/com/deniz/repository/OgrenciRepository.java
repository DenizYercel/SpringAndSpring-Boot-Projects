package com.deniz.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deniz.domain.Student;


@Repository
public interface OgrenciRepository extends JpaRepository<Student, Integer>{
	

}
