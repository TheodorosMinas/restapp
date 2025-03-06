package com.dodoscompany.somedatademo.DAO;

import com.dodoscompany.somedatademo.entities.Review;

import java.util.List;

public interface ReviewDao {
    void saveReview(Review review);
    List<Review> findAllReviews();
    Review findReviewById(int id);
    void removeReviewById(int id);
}
