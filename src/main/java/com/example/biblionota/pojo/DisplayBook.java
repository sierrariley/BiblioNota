package com.example.biblionota.pojo;

public class DisplayBook {
    private int id;
    private String name;
    private int isbn;
    private int pages;
    private String date_started;
    private String date_finished;
    private String genre_name;
    private String format_name;
    private String review_description;

    public DisplayBook(int id, String name, int isbn, int pages, String date_started, String date_finished, String genre_name, String format_name, String review_description) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.pages = pages;
        this.date_started = date_started;
        this.date_finished = date_finished;
        this.genre_name = genre_name;
        this.format_name = format_name;
        this.review_description = review_description;
    }

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

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public String getFormat_name() {
        return format_name;
    }

    public void setFormat_name(String format_name) {
        this.format_name = format_name;
    }

    public String getReview_description() {
        return review_description;
    }

    public void setReview_description(String review_description) {
        this.review_description = review_description;
    }
}
