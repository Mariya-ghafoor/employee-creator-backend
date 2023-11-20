package com.mariya.EmployeeCreator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mariya.EmployeeCreator.exceptions.NotFoundException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  // @GetMapping("/{name}")
  // public String helloWorld(@PathVariable String name) {
  // return "Hello world " + name;
  // }

  @Autowired
  private EmployeeService employeeService;

  // Get all employees records
  @GetMapping
  public ResponseEntity<List<Employee>> findAll() {
    List<Employee> allEmployees = this.employeeService.findAll();
    return new ResponseEntity<>(allEmployees, HttpStatus.OK);
  }

  // Get an employee by ID
  @GetMapping("/{id}")
  public ResponseEntity<Employee> findById(@PathVariable Long id) {

    Optional<Employee> found = this.employeeService.findById(id);

    if (found.isPresent()) {
      return new ResponseEntity<Employee>(found.get(), HttpStatus.OK);
    }

    throw new NotFoundException(String.format("Employee with id: %d does not exist", id));

  }

  // Create a new employee record
  @PostMapping
  public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeCreateDTO data) {

    Employee newEmployee = this.employeeService.createEmployee(data);
    return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {

    boolean deleted = this.employeeService.deleteEmployee(id);

    if (deleted == true) {
      return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    throw new NotFoundException(String
        .format("Post with id: %d does not exist, could not delete", id));
  }

  // Update an employee's record
  @PatchMapping("/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateDTO data) {

    Optional<Employee> updated = this.employeeService.updateById(id, data);

    if (updated.isPresent()) {
      return new ResponseEntity<Employee>(updated.get(), HttpStatus.OK);
    }

    throw new NotFoundException(String.format("Employee with id: %d does not exist", id));

    // ResponseEntity<Employee> found = this.findById(id);

    // if (found.getStatusCode() == HttpStatus.OK) {
    // Employee toUpdate = found.getBody();
    // System.out.println("*** type" + toUpdate.getClass().getName());
    // // Employee updated = this.employeeService.updateById(id, toUpdate);
    // }

  }

}
