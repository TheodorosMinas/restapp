package com.dodoscompany.somedatademo.restcontrolers;

import com.dodoscompany.somedatademo.DAO.StudentDao;
import com.dodoscompany.somedatademo.entities.Student;
import com.dodoscompany.somedatademo.exceptions.StudentErrorResponse;
import com.dodoscompany.somedatademo.exceptions.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoRestControler {
    private StudentDao studentDao;

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(400);
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, org.springframework.http.HttpStatus.BAD_REQUEST);
    }

    @Autowired
    public DemoRestControler(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GetMapping("/students")
    public List<Student> students(){
        return studentDao.findAll();
    }

    @GetMapping("/student/{id}")
    public Student student(@PathVariable int id){
        return studentDao.findByID(id);
    }

}


