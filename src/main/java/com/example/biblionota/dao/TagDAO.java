package com.example.biblionota.dao;

import com.example.biblionota.pojo.Tag;

import java.util.ArrayList;

/**
 * TagDAO Interface
 */
public interface TagDAO {
    /**
     * get all tags
     * @return
     */
    public ArrayList<Tag> getAllTags();

    /**
     * get a tag
     * @param id
     * @return
     */
    public Tag getTag(int id);

    /**
     * create a tag
     * @param tag
     */
    public void createTag(Tag tag);

    /**
     * update a tag
     * @param tag
     */
    public void updateTag(Tag tag);

    /**
     * delete a tag
     * @param id
     */
    public void deleteTag(int id);
}
