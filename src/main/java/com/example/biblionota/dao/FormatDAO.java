package com.example.biblionota.dao;

import com.example.biblionota.pojo.Format;

import java.util.ArrayList;

/**
 * FormatDAO Interface
 */
public interface FormatDAO {

    /**
     * get all formats
     * @return
     */
    public ArrayList<Format> getAllFormats();

    /**
     * get one format
     * @param id
     * @return
     */
    public Format getFormat(int id);

}
