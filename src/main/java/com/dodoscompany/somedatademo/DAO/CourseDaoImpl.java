package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CourseDaoImpl implements CourseDao {
    EntityManager entityManager;

    @Autowired
    public CourseDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void saveCourse(Course course) {
        entityManager.merge(course);

    }

    @Override
    public List<Course> findAllCourses() {
        TypedQuery<Course> query=entityManager.createQuery("SELECT s FROM Course s",Course.class);
        return query.getResultList();
    }

    @Override
    public Course findCourseById(int id) {
        Course course=entityManager.find(Course.class,id);
        if (course==null){
            throw new RuntimeException("Course not found with id "+id);
        }

        return course;
    }

    @Override
    @Transactional
    public void removeCourseById(int id) {
        Query query=entityManager.createQuery("DELETE FROM Course s WHERE s.id = :id");
        query.executeUpdate();

    }

    @Override
    public Course findCourseByIdJoinFetch(int id) {
        TypedQuery<Course> query=entityManager.createQuery("SELECT s FROM Course s JOIN FETCH s.reviews WHERE s.id=:id",Course.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
