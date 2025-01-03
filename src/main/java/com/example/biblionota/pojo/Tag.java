package com.example.biblionota.pojo;

/**
 * Tag Class
 */
public class Tag {
    //private variables
    private int id;
    private String name;

    /**
     * Arg Constructor
     * @param id
     * @param name
     */
    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Used when creating a tag without an id
     * @param name
     */
    public Tag(String name) {
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
