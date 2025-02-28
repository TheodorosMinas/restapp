package com.dodoscompany.somedatademo.restcontrolers;

import com.dodoscompany.somedatademo.DAO.EmployeeDao;
import com.dodoscompany.somedatademo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplApi")
public class EmployeeController {
    EmployeeDao employeeDao;

    @Autowired
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @PostMapping("/employee/{employee}")
    public void addEmployee(@RequestBody Employee employee){
        employeeDao.saveEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeDao.findById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeDao.findAll();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeDao.removeEmployeeById(id);
    }



}
