package com.harsh.springboot.employeecrud.dao;

import com.harsh.springboot.employeecrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;

    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        return query.getResultList();

    }

    @Override
    public Employee findById(int id) {

        return entityManager.find(Employee.class, id);

    }

    @Override
    public Employee save(Employee employee) {

        return entityManager.merge(employee);

    }

    @Override
    public void deleteById(int id) {

        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);

    }

    @Override
    public List<Employee> findAllByOrderByLastNameAsc() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee ORDER BY lastName ASC", Employee.class);
        return query.getResultList();
    }

}
