package com.sbtutorial.sbjpah2.service;

import com.sbtutorial.sbjpah2.model.Student;

public interface StudentService {

	public Iterable<Student> getStudents();
	public Student getStudent(Long id);
	public Student addStudent(Student student);
	public Student updateStudent(Long id, Student student);
	public void deleteStudent(Long id);
}
