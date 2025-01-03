package com.example.biblionota.pojo;

/**
 * Review Class
 */
public class Review {
    //private variables
    private int id;
    private String description;
    private int star_rating;

    /**
     * Args Constructor
     * @param id
     * @param description
     * @param star_rating
     */
    public Review(int id, String description, int star_rating) {
        this.id = id;
        this.description = description;
        this.star_rating = star_rating;
    }

    /**
     * String, Int Args
     * @param description
     * @param star_rating
     */
    public Review(String description, int star_rating) {
        this.description = description;
        this.star_rating = star_rating;
    }

    /**
     * String Args
     * @param description
     */
    public Review(String description) {
        this.description = description;

    }

    /**
     * Full Args
     * @param description
     * @param star_rating
     * @param id
     */
    public Review(String description, int star_rating, int id) {
        this.description = description;
        this.star_rating = star_rating;
        this.id = id;
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
