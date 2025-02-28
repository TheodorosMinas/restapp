package com.dodoscompany.somedatademo.restcontrolers;

import com.dodoscompany.somedatademo.DAO.StudentDao;
import com.dodoscompany.somedatademo.entities.Student;
import com.dodoscompany.somedatademo.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestControler {
    private StudentDao studentDao;



    @Autowired
    public DemoRestControler(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/students")
    public List<Student> students(){
        List<Student> students = studentDao.findAll();
        if (students.isEmpty()) {
            throw new StudentNotFoundException("Students not found");
        }
        return studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public Student student(@PathVariable int id){
        Student student = studentDao.findByID(id);
        if(student == null){
            throw new StudentNotFoundException("Student not found - " + id);
        }
        return studentDao.findByID(id);
    }

}


