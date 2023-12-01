package com.example.biblionota.pojo;

/**
 * Book Class
 */
public class Book {
    //private variables
    private int id;
    private String name;
    private int isbn;
    private int pages;
    private String date_started;
    private String date_finished;
    private int genre;
    private int format;
    private int review;

    /**
     * Constructor
     * @param id
     * @param name
     * @param isbn
     * @param pages
     * @param date_started
     * @param date_finished
     * @param genre
     * @param format
     * @param review
     */
    public Book(int id, String name, int isbn, int pages, String date_started, String date_finished, int genre, int format, int review) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.pages = pages;
        this.date_started = date_started;
        this.date_finished = date_finished;
        this.genre = genre;
        this.format = format;
        this.review = review;
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
    public int getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public String getDate_started() {
        return date_started;
    }
    public void setDate_started(String date_started) {
        this.date_started = date_started;
    }
    public String getDate_finished() {
        return date_finished;
    }
    public void setDate_finished(String date_finished) {
        this.date_finished = date_finished;
    }
    public int getGenre() {
        return genre;
    }
    public void setGenre(int genre) {
        this.genre = genre;
    }
    public int getFormat() {
        return format;
    }
    public void setFormat(int format) {
        this.format = format;
    }
    public int getReview() {
        return review;
    }
    public void setReview(int review) {
        this.review = review;
    }

    //toString
    @Override
    public String toString() {
        return name;
    }
}
