package com.example.biblionota.pojo;

/**
 * Author Class
 */
public class Author {
    //private variables
    private int id;
    private String name;
    //constructor

    /**
     * Args Constructor
     * @param id
     * @param name
     */
    public Author(int id, String name) {
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
