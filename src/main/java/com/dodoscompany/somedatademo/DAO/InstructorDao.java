package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Instructor;

import java.util.List;

public interface InstructorDao {
    void saveInstructor(Instructor instructor);
    List<Instructor> findAllInstructors();
    Instructor findInstructorById(int id);
    void removeInstructorById(int id);
    Instructor findInstructorByIdJoinFetch(int id);


}
