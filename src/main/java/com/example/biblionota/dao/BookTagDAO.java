package com.example.biblionota.dao;

import com.example.biblionota.pojo.BookTag;

import java.util.ArrayList;

/**
 * BookTagDAO Interface
 */
public interface BookTagDAO {

    /**
     * get all booktags
     * @return
     */
    public ArrayList<BookTag> getAllBookTag();

    /**
     * get one booktag
     * @param id
     * @return
     */
    public BookTag getBookTag(int id);
}
