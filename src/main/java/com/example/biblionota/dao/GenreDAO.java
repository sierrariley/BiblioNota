package com.example.biblionota.dao;

import com.example.biblionota.pojo.Genre;

import java.util.ArrayList;

/**
 * GenreDAO
 */
public interface GenreDAO {

    /**
     * get all genres
     * @return
     */
    public ArrayList<Genre> getAllGenres();

    /**
     * get one genre
     * @param id
     * @return
     */
    public Genre getGenre(int id);

    /**
     * create a genre
     * @param genre
     */
    public void createGenre(Genre genre);

    /**
     * update a genre
     * @param genre
     */
    public void updateGenre(Genre genre);

}
