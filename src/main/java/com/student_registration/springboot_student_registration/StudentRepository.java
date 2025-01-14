package com.student_registration.springboot_student_registration;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

	List<Student> findByName(String name);

}
