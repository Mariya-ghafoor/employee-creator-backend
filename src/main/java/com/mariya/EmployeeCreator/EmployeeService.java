package com.mariya.EmployeeCreator;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private ModelMapper modelMapper;

  public List<Employee> findAll() {
    return this.employeeRepository.findAll();
  }

  public Optional<Employee> findById(Long id) {
    Optional<Employee> found = this.employeeRepository.findById(id);
    return found;

  }

  public Employee createEmployee(EmployeeCreateDTO data) {

    // String firstName = data.getFirstName();
    // String lastName = data.getLastName();
    // String email = data.getEmail();

    // Employee newEmployee = new Employee(firstName, lastName, email);

    Employee newEmployee = modelMapper.map(data, Employee.class);

    Employee created = this.employeeRepository.save(newEmployee);

    return created;

  }

  public Boolean deleteEmployee(Long id) {
    Optional<Employee> foundEmployee = this.findById(id);

    if (foundEmployee.isPresent()) {
      this.employeeRepository.delete(foundEmployee.get());
      return true;
    }
    return false;
  }

  public Optional<Employee> updateById(Long id, EmployeeUpdateDTO data) {
    Optional<Employee> foundEmployee = this.findById(id);

    if (foundEmployee.isPresent()) {
      Employee toUpdate = foundEmployee.get();
      modelMapper.map(data, toUpdate);

      Employee updatedEmployee = this.employeeRepository.save(toUpdate);

      return Optional.of(updatedEmployee);

    }
    return foundEmployee;

  }

}
