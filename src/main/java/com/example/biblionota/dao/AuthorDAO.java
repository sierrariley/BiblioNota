package com.example.biblionota.dao;

import com.example.biblionota.pojo.Author;

import java.util.ArrayList;

public interface AuthorDAO {
    public ArrayList<Author> getAllAuthors();
    public Author getAuthor(int id);
}
