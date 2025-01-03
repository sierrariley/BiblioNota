package com.example.biblionota.pojo;

/**
 * Format Class
 */
public class Format {
    //private variables
    private int id;
    private String type;

    /**
     * Args Constructor
     * @param id
     * @param type
     */
    public Format(int id, String type) {
        this.id = id;
        this.type = type;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //toString
    @Override
    public String toString() {
        return type;
    }
}
