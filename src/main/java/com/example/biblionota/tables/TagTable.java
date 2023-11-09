package com.example.biblionota.tables;

import com.example.biblionota.dao.TagDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Tag;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TagTable implements TagDAO {
    Database db = Database.getInstance();
    ArrayList<Tag> tags;
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
}