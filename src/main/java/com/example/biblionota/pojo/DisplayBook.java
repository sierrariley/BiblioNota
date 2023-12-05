package com.example.biblionota.pojo;

/**
 * DisplayBook Class
 */
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
    private int review_star_rating;
    private String author_names;
    private String tag_names;

    /**
     * Args Constructor
     * @param id
     * @param name
     * @param isbn
     * @param pages
     * @param date_started
     * @param date_finished
     * @param genre_name
     * @param format_name
     * @param review_description
     * @param review_star_rating
     * @param author_names
     * @param tag_names
     */
    public DisplayBook(int id, String name, int isbn, int pages, String date_started, String date_finished, String genre_name, String format_name, String review_description, int review_star_rating, String author_names, String tag_names) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.pages = pages;
        this.date_started = date_started;
        this.date_finished = date_finished;
        this.genre_name = genre_name;
        this.format_name = format_name;
        this.review_description = review_description;
        this.review_star_rating = review_star_rating;
        this.author_names = author_names;
        this.tag_names = tag_names;
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

    public int getReview_star_rating() {
        // TODO: U+2605
        return review_star_rating;
    }

    public void setReview_star_rating(int review_star_rating) {
        this.review_star_rating = review_star_rating;
    }

    public String getAuthor_names() {
        return author_names;
    }

    public void setAuthor_names(String author_names) {
        this.author_names = author_names;
    }

    /**
     * Returns empty space instead of "null" if no tags are available
     * @return
     */
    public String getTag_names() {
        if (tag_names != null) {
            return tag_names;
        }
        return " ";

    }

    public void setTag_names(String tag_names) {
        this.tag_names = tag_names;
    }
}
