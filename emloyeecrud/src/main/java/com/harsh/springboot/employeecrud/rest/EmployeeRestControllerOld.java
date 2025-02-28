package com.harsh.springboot.employeecrud.rest;

import com.harsh.springboot.employeecrud.entity.Employee;
import com.harsh.springboot.employeecrud.exception.EmployeeNotFoundException;
import com.harsh.springboot.employeecrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-old")
public class EmployeeRestControllerOld {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestControllerOld(EmployeeService employeeService) {

        this.employeeService = employeeService;

    }

    @GetMapping("/employees")
    public List<Employee> findAll() {

        return this.employeeService.findAll();

    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {

            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);

        }

        return employee;

    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        return this.employeeService.save(employee);

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        return this.employeeService.save(employee);

    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = this.employeeService.findById(employeeId);

        if (employee == null) {

            throw new EmployeeNotFoundException("Employee id not found - " + employeeId);

        }

        this.employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;

    }

}
