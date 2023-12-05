package com.example.biblionota.tables;

import com.example.biblionota.dao.ReviewDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Genre;
import com.example.biblionota.pojo.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * ReviewTable Class Implements ReviewDAO
 */
public class ReviewTable implements ReviewDAO {
    private static ReviewTable instance;
    Database db;
    ArrayList<Review> reviews;

    /**
     *
     * @return
     */
    private ReviewTable() { db = Database.getInstance(); }

    /**
     * Gives all reviews from table
     * @return
     */
    @Override
    public ArrayList<Review> getAllReviews() {
        String query = "SELECT * FROM " + DBConst.TABLE_REVIEW;
        reviews = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                reviews.add(new Review(
                        data.getInt(DBConst.REVIEW_COLUMN_ID),
                        data.getString(DBConst.REVIEW_COLUMN_DESC),
                        data.getInt(DBConst.REVIEW_COLUMN_STARS)
                ));
            }
            return reviews;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get review by its id
     * @param id
     * @return
     */
    @Override
    public Review getReview(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_REVIEW +
                " WHERE " + DBConst.REVIEW_COLUMN_ID + " = " + id;
        reviews = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Review(
                        data.getInt(DBConst.REVIEW_COLUMN_ID),
                        data.getString(DBConst.REVIEW_COLUMN_DESC),
                        data.getInt(DBConst.REVIEW_COLUMN_STARS)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create a new review for the table
     * @param review
     */
    @Override
    public void createReview(Review review) {
        String query = "INSERT INTO " + DBConst.TABLE_REVIEW +
                "(" + DBConst.REVIEW_COLUMN_DESC + ", " +
                DBConst.REVIEW_COLUMN_STARS +") VALUES ('" +
                review.getDescription() + "', '" +
                review.getStar_rating() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (Exception e) {
            System.out.println("break");
            e.printStackTrace();
        }
    }

    /**
     * Update a review that has been made
     * @param review
     */
    @Override
    public void updateReview(Review review) {
        String query = "UPDATE " + DBConst.TABLE_REVIEW + " SET " +
                DBConst.REVIEW_COLUMN_DESC + " = '" + review.getDescription() + "', " +
                DBConst.REVIEW_COLUMN_STARS + " = " + review.getStar_rating() +
                " WHERE " + DBConst.REVIEW_COLUMN_ID + " = " + review.getId();

        System.out.println(query);
        try {
            Statement updateReview = db.getConnection().createStatement();
            updateReview.executeUpdate(query);
            System.out.println("Record Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    public void updateStarRating(Review review) {
//        String query = "UPDATE " + DBConst.TABLE_REVIEW + " SET " +
//                DBConst.REVIEW_COLUMN_STARS + " = " + review.getStar_rating() +
//                " WHERE " + DBConst.REVIEW_COLUMN_ID + " = " + review.getId();
//        try {
//            Statement updateReview = db.getConnection().createStatement();
//            updateReview.executeUpdate(query);
//            System.out.println("Record Updated");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * Delete a review using its id
     * @param id
     */
    @Override
    public void deleteReview(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_REVIEW + " WHERE " +
                DBConst.REVIEW_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Grabs last is of review created
     * @return
     */
    public int getLastId(){
        int id = -1;
        try{
            PreparedStatement getId = db.getConnection().prepareStatement("SELECT last_insert_id()  as id");
            ResultSet data = getId.executeQuery();
            data.next();
            id = data.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    public static ReviewTable getInstance() {
        if(instance == null){
            instance = new ReviewTable();
        }
        return instance;
    }


}
