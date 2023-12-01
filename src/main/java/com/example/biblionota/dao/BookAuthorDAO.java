package com.example.biblionota.dao;

import com.example.biblionota.pojo.BookAuthor;

import java.util.ArrayList;

/**
 * BookAuthor DAO Interface
 */
public interface BookAuthorDAO {

    /**
     * get all BookAuthors
     * @return ArrayList
     */
    public ArrayList<BookAuthor> getAllBookAuthor();

    /**
     * get one BookAuthor
     * @param id
     * @return
     */
    public BookAuthor getBookAuthor(int id);
}
