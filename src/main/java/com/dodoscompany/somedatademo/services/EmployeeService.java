package com.dodoscompany.somedatademo.services;

import com.dodoscompany.somedatademo.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee saveEmployee(Employee employee);
    Employee findById(int id);
    void removeEmployeeById(int id);



}
