package com.harsh.springboot.employeecrud.service;

import com.harsh.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    List<Employee> findAllByOrderByLastNameAsc();

}
