package com.sbtutorial.sbjpamysql.dao;

import com.sbtutorial.sbjpamysql.model.Student;

public interface StudentDAO {

	public Iterable<Student> getStudents();
	public Student getStudent(Long id);
	public Student addStudent(Student student);
	public Student updateStudent(Long id, Student student);
	public void deleteStudent(Long id);
}