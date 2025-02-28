package com.harsh.springboot.employeecrud.dao;

import com.harsh.springboot.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    List<Employee> findAllByOrderByLastNameAsc();

}
