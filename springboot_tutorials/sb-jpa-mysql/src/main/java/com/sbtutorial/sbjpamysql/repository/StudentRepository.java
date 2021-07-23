package com.sbtutorial.sbjpamysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.sbtutorial.sbjpamysql.model.Student;
 
public interface StudentRepository extends CrudRepository<Student, Long> {
 
}