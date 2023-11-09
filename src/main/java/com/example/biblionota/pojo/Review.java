package com.example.biblionota.pojo;

public class Review {
    //private variables
    private int id;
    private String name;
    private int star_rating;

    //constructor
    public Review(int id, String name, int star_rating) {
        this.id = id;
        this.name = name;
        this.star_rating = star_rating;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return name;
    }
}
