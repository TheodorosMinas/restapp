package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Course;
import com.dodoscompany.somedatademo.entities.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDao {
    EntityManager entityManager;

    @Autowired
    public InstructorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }


    @Override
    public List<Instructor> findAllInstructors() {
        TypedQuery<Instructor> query = entityManager.createQuery("Select s from Instructor s", Instructor.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        //instructor.getCourses().size();
            if (instructor == null) {
                throw new RuntimeException("Instructor not found with id " + id);
            }
        return instructor;
    }

    @Override
    @Transactional
    public void removeInstructorById(int id) {
        Query query=entityManager.createQuery("DELETE FROM Instructor s WHERE s.id = :id");
        query.setParameter("id", id);
        Instructor instructor = entityManager.find(Instructor.class, id);
        for (Course course : instructor.getCourses()) {
            course.setInstructor(null);
        }
        instructor.setCourses(null);
        query.executeUpdate();

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        Instructor instructor = entityManager.createQuery("Select i from Instructor i JOIN FETCH i.courses where i.id=:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
        return instructor;
    }
}
