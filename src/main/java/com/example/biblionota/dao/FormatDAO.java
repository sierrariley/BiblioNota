package com.example.biblionota.dao;

import com.example.biblionota.pojo.Format;

import java.util.ArrayList;

public interface FormatDAO {

    public ArrayList<Format> getAllFormats();

    public Format getFormat(int id);
}
