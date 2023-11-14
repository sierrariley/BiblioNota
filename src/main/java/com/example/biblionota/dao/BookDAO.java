package com.example.biblionota.dao;

import com.example.biblionota.pojo.Book;

import java.util.ArrayList;

public interface BookDAO {
    public ArrayList<Book> getAllBooks();
    public Book getBook(int id);

    public void createBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(int id);
}
