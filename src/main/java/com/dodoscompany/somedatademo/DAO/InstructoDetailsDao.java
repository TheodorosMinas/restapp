package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.InstructorDetail;

import java.util.List;

public interface InstructoDetailsDao {
    void saveInstructorDetails(InstructorDetail instructorDetail);
    List<InstructorDetail> findAllInstructorDetails();
    InstructorDetail findInstructorDetailsById(int id);
    void removeInstructorDetailsById(int id);
}
