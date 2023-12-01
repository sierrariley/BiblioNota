package com.example.biblionota.pojo;

public class BookTag {
    //private variables
    private int id;
    private int book_id;
    private int tag_id;
    //constructor

    public BookTag(int id, int book_id, int tag_id) {
        this.id = id;
        this.book_id = book_id;
        this.tag_id = tag_id;
    }

    public BookTag(int book_id, int tag_id) {
        this.book_id = book_id;
        this.tag_id = tag_id;
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

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }


    //toString
    @Override
    public String toString() {
        return "BookTag{" +
                "book_id=" + book_id +
                ", tag_id=" + tag_id +
                '}';
    }
}
