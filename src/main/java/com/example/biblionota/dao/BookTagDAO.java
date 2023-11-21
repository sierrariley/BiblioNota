package com.example.biblionota.dao;

import com.example.biblionota.pojo.BookTag;

import java.util.ArrayList;

public interface BookTagDAO {

    public ArrayList<BookTag> getAllBookTag();
    public BookTag getBookTag(int id);
}
