package com.example.biblionota.dao;

import com.example.biblionota.pojo.Book;

import java.util.ArrayList;

public interface BookDAO {
    public ArrayList<Book> getAllBooks();
    public Book getBook(int id);

    //This interface may look similar to the ItemDAO from the MDTracker?
}
