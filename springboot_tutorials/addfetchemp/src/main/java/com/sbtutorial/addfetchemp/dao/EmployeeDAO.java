package com.sbtutorial.addfetchemp.dao;

import org.springframework.data.repository.CrudRepository;

import com.sbtutorial.addfetchemp.model.Employee;

public interface EmployeeDAO extends CrudRepository<Employee, Integer>{

}
