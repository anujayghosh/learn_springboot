package com.sbtutorial.sbjpah2.dao;

import org.springframework.data.repository.CrudRepository;

import com.sbtutorial.sbjpah2.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}