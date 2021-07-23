package com.sbtutorial.sbjpamysql.service;

import com.sbtutorial.sbjpamysql.model.Student;

public interface StudentService {

	public Iterable<Student> getStudents();
	public Student getStudent(Long id);
	public Student addStudent(Student student);
	public Student updateStudent(Long id, Student student);
	public void deleteStudent(Long id);
}
