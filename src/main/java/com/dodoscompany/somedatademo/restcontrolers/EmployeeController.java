package com.dodoscompany.somedatademo.restcontrolers;

import com.dodoscompany.somedatademo.entities.Employee;
import com.dodoscompany.somedatademo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emplApi")
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
     return    employeeService.saveEmployee(employee);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return    employeeService.saveEmployee(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.findById(id);
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @DeleteMapping("/employee/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.removeEmployeeById(id);
    }



}
