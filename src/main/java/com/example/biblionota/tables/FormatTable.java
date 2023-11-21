package com.example.biblionota.tables;

import com.example.biblionota.dao.FormatDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Author;
import com.example.biblionota.pojo.Format;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FormatTable implements FormatDAO {
    private static FormatTable instance;
    Database db;
    private FormatTable() { db = Database.getInstance(); }
    ArrayList<Format> formats;
    @Override
    public ArrayList<Format> getAllFormats() {
        String query = "SELECT * FROM " + DBConst.TABLE_FORMAT;
        formats = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                formats.add(new Format(
                        data.getInt(DBConst.FORMAT_COLUMN_ID),
                        data.getString(DBConst.FORMAT_COLUMN_NAME)
                ));
            }
            return formats;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Format getFormat(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_FORMAT +
                " WHERE " + DBConst.FORMAT_COLUMN_ID + " = " + id;
        formats = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Format(
                        data.getInt(DBConst.FORMAT_COLUMN_ID),
                        data.getString(DBConst.FORMAT_COLUMN_NAME)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FormatTable getInstance() {
        if(instance == null){
            instance = new FormatTable();
        }
        return instance;
    }
}
