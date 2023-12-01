package com.example.biblionota.dao;

import com.example.biblionota.pojo.Review;

import java.util.ArrayList;

/**
 * ReviewDAO Interface
 */
public interface ReviewDAO {

    /**
     * get all reviews
     * @return
     */
    public ArrayList<Review> getAllReviews();

    /**
     * get one review
     * @param id
     * @return
     */
    public Review getReview(int id);

    /**
     * create a review
     * @param review
     */
    public void createReview(Review review);

    /**
     * update a review
     * @param review
     */
    public void updateReview(Review review);

    /**
     * delete a review
     * @param id
     */
    public void deleteReview(int id);
}
