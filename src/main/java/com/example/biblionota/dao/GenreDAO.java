package com.example.biblionota.dao;

import com.example.biblionota.pojo.Genre;

import java.util.ArrayList;

public interface GenreDAO {

    public ArrayList<Genre> getAllGenres();

    public Genre getGenre(int id);

    public void createGenre(Genre genre);
    public void updateGenre(Genre genre);

}
