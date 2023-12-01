package com.example.biblionota.pojo;

/**
 * Genre Class
 */
public class Genre {
    //private variables
    private int id;
    private String name;

    /**
     * Args Constructor
     * @param id
     * @param name
     */
    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
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

    //toString

    @Override
    public String toString() {
        return name;
    }
}
