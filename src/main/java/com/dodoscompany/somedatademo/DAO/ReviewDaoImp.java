package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ReviewDaoImp implements ReviewDao {
    EntityManager entityManager;

    @Autowired
    public ReviewDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void saveReview(Review review) {
        entityManager.merge(review);
    }

    @Override
    public List<Review> findAllReviews() {
        TypedQuery<Review> query = entityManager.createQuery("Select s from Review s", Review.class);
        return query.getResultList();
    }

    @Override
    public Review findReviewById(int id) {
        return entityManager.find(Review.class, id);
    }

    @Override
    @Transactional
    public void removeReviewById(int id) {
        Review review = entityManager.find(Review.class, id);
        if (review == null) {
            throw new RuntimeException("Review not found with id " + id);
        }
        entityManager.remove(review);
    }
}
