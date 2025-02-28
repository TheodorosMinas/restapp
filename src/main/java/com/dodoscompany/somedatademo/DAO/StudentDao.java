package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Student;

import java.util.List;

public interface   StudentDao {

    void saveStudent(Student student) ;
    Student findByID(int id);
    List<Student> findAll();
    List<Student> findbyFirstName(String firstName);
    void removeStudentById(int id);
    void removeStudentByFirstName(String firstName);
    void updateStudentFirstName(Student student,String firstName);
    void removeStudent(Student student);
    void removeAllStudents();

}
