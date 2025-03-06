package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Course;

import java.util.List;

public interface CourseDao {
    void saveCourse(Course course);
    List<Course> findAllCourses();
    Course findCourseById(int id);
    void removeCourseById(int id);
    Course findCourseByIdJoinFetch(int id);
}
