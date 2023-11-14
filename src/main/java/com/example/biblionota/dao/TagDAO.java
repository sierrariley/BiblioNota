package com.example.biblionota.dao;

import com.example.biblionota.pojo.Tag;

import java.util.ArrayList;

public interface TagDAO {
    public ArrayList<Tag> getAllTags();

    public Tag getTag(int id);

    public void createTag(Tag tag);
    public void updateTag(Tag tag);
    public void deleteTag(int id);
}
