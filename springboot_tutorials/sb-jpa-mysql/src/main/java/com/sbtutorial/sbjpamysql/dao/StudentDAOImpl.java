package com.sbtutorial.sbjpamysql.dao;

import org.springframework.stereotype.Repository;
import com.sbtutorial.sbjpamysql.exceptions.StudentNotFoundException;
import com.sbtutorial.sbjpamysql.model.Student;
import com.sbtutorial.sbjpamysql.repository.StudentRepository;

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
