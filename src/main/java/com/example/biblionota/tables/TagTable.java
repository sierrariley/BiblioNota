package com.example.biblionota.tables;

import com.example.biblionota.dao.TagDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Tag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * TagTable Class Implements TagDAO
 */
public class TagTable implements TagDAO {
    private static TagTable instance;
    Database db;
    ArrayList<Tag> tags;

    private TagTable() { db = Database.getInstance(); }

    @Override
    /**
     * Grab all tags from table
     */
    public ArrayList<Tag> getAllTags() {
        String query = "SELECT * FROM " + DBConst.TABLE_TAGS;
        tags = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                tags.add(new Tag(
                        data.getInt(DBConst.TAGS_COLUMN_ID),
                        data.getString(DBConst.TAGS_COLUMN_NAME)
                ));
            }
            return tags;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get single tag based on its id
     * @param id
     * @return
     */
    @Override
    public Tag getTag(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_TAGS +
                " WHERE " + DBConst.TAGS_COLUMN_ID + " = " + id;
        tags = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Tag(
                        data.getInt(DBConst.TAGS_COLUMN_ID),
                        data.getString(DBConst.TAGS_COLUMN_NAME)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Create a new tag
     * @param tag
     */
    @Override
    public void createTag(Tag tag) {
        String query = "INSERT INTO " + DBConst.TABLE_TAGS +
                "(" + DBConst.TAGS_COLUMN_NAME + ") VALUES ('" +
                tag.getName() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update a tag already set to a book
     * @param tag
     */
    @Override
    public void updateTag(Tag tag) {
        String query = "UPDATE " + DBConst.TABLE_TAGS + " SET " +
                DBConst.TAGS_COLUMN_NAME + " = '" + tag.getName() + "' " +
                " WHERE " + DBConst.TAGS_COLUMN_ID + " = " + tag.getId();
        try {
            Statement updateTag = db.getConnection().createStatement();
            updateTag.executeUpdate(query);
            System.out.println("Record Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete a tag based on its id
     * @param id
     */
    @Override
    public void deleteTag(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_TAGS + " WHERE " +
                DBConst.TAGS_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static TagTable getInstance() {
        if(instance == null){
            instance = new TagTable();
        }
        return instance;
    }

    /**
     * Grabs last id of tag created
     * @return
     */
    public int getLastId(){
        int id = -1;
        try{
            PreparedStatement getId = db.getConnection().prepareStatement("SELECT last_insert_id()  as id");
            ResultSet data = getId.executeQuery();
            data.next();
            id = data.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
