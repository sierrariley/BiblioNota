package com.example.biblionota.dao;

import com.example.biblionota.pojo.BookAuthor;

import java.util.ArrayList;

public interface BookAuthorDAO {

    public ArrayList<BookAuthor> getAllBookAuthor();
    public BookAuthor getBookAuthor(int id);
}
