package com.example.biblionota.dao;

import com.example.biblionota.pojo.Author;
import java.util.ArrayList;

/**
 * Author DAO Interface
 */
public interface AuthorDAO {
    /**
     * get all authors
     * @return ArrayList
     */
    public ArrayList<Author> getAllAuthors();

    /**
     * get one author
     * @param id
     * @return
     */
    public Author getAuthor(int id);

    /**
     * create an author
     * @param author
     */
    public void createAuthor(Author author);

    /**
     * delete an author
     * @param id
     */
    public void deleteAuthor(int id);
}
