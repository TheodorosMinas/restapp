package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    void saveEmployee(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    void removeEmployeeById(int id);
}
