package com.harsh.springboot.employeecrud.service;

import com.harsh.springboot.employeecrud.dao.EmployeeDAO;
import com.harsh.springboot.employeecrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {

        this.employeeDAO = employeeDAO;

    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        return this.employeeDAO.findAll();

    }

    @Override
    @Transactional
    public Employee findById(int id) {

        return this.employeeDAO.findById(id);

    }

    @Override
    @Transactional
    public Employee save(Employee employee) {

        return this.employeeDAO.save(employee);

    }

    @Override
    @Transactional
    public void deleteById(int id) {

        this.employeeDAO.deleteById(id);

    }

    @Override
    @Transactional
    public List<Employee> findAllByOrderByLastNameAsc() {

        return this.employeeDAO.findAllByOrderByLastNameAsc();

    }
}
