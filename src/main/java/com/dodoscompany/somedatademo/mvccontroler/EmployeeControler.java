package com.dodoscompany.somedatademo.mvccontroler;


import com.dodoscompany.somedatademo.entities.Employee;
import com.dodoscompany.somedatademo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dodos")
public class EmployeeControler {
    EmployeeService employeeService;

    @Autowired
    public EmployeeControler(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("/employees")
    public String showFormForAdd(Model model) {
        Employee deleteEmployee = new Employee();
        List<Employee> employees = employeeService.findAll();
        List<Employee> delEmpl = new ArrayList<>();
        for (int i=0;i<employees.size();i++){
            delEmpl.add(new Employee());
        }


        deleteEmployee.setFirstName("vlakas");
        model.addAttribute("delEmpl", deleteEmployee);
        model.addAttribute("employees", employeeService.findAll());
        return "shoeEmplSheet";
    }

    @PostMapping("/deleteEmployee")
    public String removeEmployee(@RequestParam("id") int id) {

        employeeService.removeEmployeeById(id);
        return "redirect:/dodos/employees";
    }
    @GetMapping("/addEmployee")
    public String addEmployee(Model model) {
        model.addAttribute("employee",new Employee());

        return "addEmpl";
    }

    @PostMapping("/addingEmployee")
    public String addingEmployee(@ModelAttribute("employee") Employee employee) {
        System.out.println(employeeService.saveEmployee(employee));
        return "redirect:/dodos/employees";
    }
}



