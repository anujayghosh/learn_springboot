package com.sbtutorial.sbjpamysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbtutorial.sbjpamysql.model.Student;
import com.sbtutorial.sbjpamysql.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	//	private final StudentRepository repository;
	////	Constructor Injection
	//	public StudentController(StudentRepository repository) {
	//	    this.repository = repository;
	//	}

	@Autowired
	StudentService studentService;

	@GetMapping
	public Iterable<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/{id}")
	public Student getStudent(@PathVariable Long id) {
		return studentService.getStudent(id);
	}   

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	} 

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
	}

}