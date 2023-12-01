package com.example.biblionota.pojo;

/**
 * BookAuthor Class
 */
public class BookAuthor {
    //private variables
    private int id;
    private int book_id;
    private int author_id;

    /**
     * Args Constructor
     * @param id
     * @param book_id
     * @param tag_id
     */
    public BookAuthor(int id, int book_id, int tag_id) {
        this.id = id;
        this.book_id = book_id;
        this.author_id = tag_id;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int tag_id) {
        this.author_id = tag_id;
    }


    //toString
    @Override
    public String toString() {
        return "BookTag{" +
                "book_id=" + book_id +
                ", author_id=" + author_id +
                '}';
    }
}
