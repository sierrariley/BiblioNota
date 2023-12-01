package com.example.biblionota.tables;

import com.example.biblionota.dao.TagDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Tag;
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
}
