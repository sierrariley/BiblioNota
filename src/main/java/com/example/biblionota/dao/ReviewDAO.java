package com.example.biblionota.dao;

import com.example.biblionota.pojo.Review;

import java.util.ArrayList;

public interface ReviewDAO {

    public ArrayList<Review> getAllReviews();

    public Review getReview(int id);
}
