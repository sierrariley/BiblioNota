package com.example.biblionota.pojo;

public class Review {
    //private variables
    private int id;
    private String description;
    private int star_rating;

    //constructor
    public Review(int id, String description, int star_rating) {
        this.id = id;
        this.description = description;
        this.star_rating = star_rating;
    }

    public Review(int star_rating) {
        this.star_rating = star_rating;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String name) {
        this.description = description;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    //toString
    @Override
    public String toString() {
        return description;
    }
}
