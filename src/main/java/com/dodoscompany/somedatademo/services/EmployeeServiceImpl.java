package com.dodoscompany.somedatademo.services;

import com.dodoscompany.somedatademo.DAO.EmployeeDao;
import com.dodoscompany.somedatademo.entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
    public List<Employee> findAll() {
      return   employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee saveEmployee(Employee employee) {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public void removeEmployeeById(int id) {
        employeeDao.removeEmployeeById(id);
    }


}
