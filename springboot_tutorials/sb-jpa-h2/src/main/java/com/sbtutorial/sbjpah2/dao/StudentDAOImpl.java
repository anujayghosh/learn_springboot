package com.sbtutorial.sbjpah2.dao;

import org.springframework.stereotype.Repository;

import com.sbtutorial.sbjpah2.exceptions.StudentNotFoundException;
import com.sbtutorial.sbjpah2.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private final StudentRepository repository;
	//Constructor Injection
	public StudentDAOImpl(StudentRepository repository) {
		this.repository = repository;
	}

	public Iterable<Student> getStudents() {
		return repository.findAll();
	}


	public Student getStudent(Long id) {
		return repository.findById(id).orElseThrow(StudentNotFoundException::new);
	}   


	public Student addStudent(Student student) {
		return repository.save(student);
	} 


	public Student updateStudent(Long id, Student student) {
		Student studentToUpdate = repository.findById(id).orElseThrow(StudentNotFoundException::new);

		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setYear(student.getYear());

		return repository.save(studentToUpdate);
	}


	public void deleteStudent(Long id) {
		repository.findById(id).orElseThrow(StudentNotFoundException::new);
		repository.deleteById(id);
	}


}
