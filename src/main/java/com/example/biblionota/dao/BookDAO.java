package com.example.biblionota.dao;

import com.example.biblionota.pojo.Book;

import java.util.ArrayList;

/**
 * BookDAO Interface
 */
public interface BookDAO {
    /**
     * get all books
     * @return ArrayList
     */
    public ArrayList<Book> getAllBooks();

    /**
     * get a book
     * @param id
     * @return
     */
    public Book getBook(int id);

    /**
     * create a book
     * @param book
     */
    public void createBook(Book book);

    /**
     * update a book
     * @param book
     */
    public void updateBook(Book book);

    /**
     * delete a book
     * @param id
     */
    public void deleteBook(int id);
}
