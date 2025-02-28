package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImp implements StudentDao {
    EntityManager entityManager;

    @Autowired
    public StudentDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findByID(int id) {
        return   entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s  ", Student.class);
        return query.getResultList();

    }

    @Override
    public List<Student> findbyFirstName(String firstName) {
        TypedQuery<Student> query=entityManager.createQuery("SELECT s FROM Student s WHERE s.firstName=:firstName",Student.class);
        query.setParameter("firstName",firstName);

        return  query.getResultList();
    }

    @Override
    @Transactional
    public void removeStudentById(int id) {
        Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void removeStudentByFirstName(String firstName) {
        Query query = entityManager.createQuery("DELETE FROM Student s WHERE s.firstName = :firstName");
        query.setParameter("firstName", firstName);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void updateStudentFirstName(Student student,String firstName) {
        student.setFirstName(firstName);
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void removeStudent(Student student) {
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public void removeAllStudents() {
        Query query=entityManager.createQuery("DELETE FROM Student s");
        int res=query.executeUpdate();
        if (res>0){
            System.out.println("All students removed "+res);
        }
    }


}
