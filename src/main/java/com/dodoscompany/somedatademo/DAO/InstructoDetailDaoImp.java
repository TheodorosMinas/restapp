package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructoDetailDaoImp implements InstructoDetailsDao {
    EntityManager entityManager;

    @Autowired
    public InstructoDetailDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructorDetails(InstructorDetail instructorDetail) {
        entityManager.merge(instructorDetail);
    }


    @Override
    public List<InstructorDetail> findAllInstructorDetails() {
        TypedQuery<InstructorDetail> query = entityManager.createQuery("Select s from InstructorDetail s", InstructorDetail.class);
        return query.getResultList();
    }

    @Override
    public InstructorDetail findInstructorDetailsById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
            if (instructorDetail == null) {
                throw  new RuntimeException("Instructor Detail not found with id "+id);
            }
        return instructorDetail;

    }

    @Override
    @Transactional
    public void removeInstructorDetailsById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);

        if (instructorDetail == null) {
            throw  new RuntimeException("Instructor Detail not found with id so no delete "+id);
        }
        entityManager.remove(instructorDetail);

    }
}
