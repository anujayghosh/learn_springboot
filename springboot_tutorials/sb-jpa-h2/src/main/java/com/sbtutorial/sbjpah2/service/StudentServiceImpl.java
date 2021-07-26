package com.sbtutorial.sbjpah2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbtutorial.sbjpah2.dao.StudentDAO;
import com.sbtutorial.sbjpah2.model.Student;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;

	public Iterable<Student> getStudents() {
		return studentDAO.getStudents();
	}


	public Student getStudent(Long id) {
		return studentDAO.getStudent(id);
	}   


	public Student addStudent(Student student) {
		return studentDAO.addStudent(student);
	} 


	public Student updateStudent(Long id,Student student) {
		return studentDAO.updateStudent(id, student);
	}


	public void deleteStudent(Long id) {
		studentDAO.deleteStudent(id);
	}

}
