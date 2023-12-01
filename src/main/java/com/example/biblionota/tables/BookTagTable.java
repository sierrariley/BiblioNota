package com.example.biblionota.tables;

import com.example.biblionota.dao.BookTagDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.BookAuthor;
import com.example.biblionota.pojo.BookTag;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTagTable implements BookTagDAO {
    private static BookTagTable instance;
    Database db;
    private BookTagTable() { db = Database.getInstance(); }
    ArrayList<BookTag> booksTags;
    @Override
    public ArrayList<BookTag> getAllBookTag() {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK_TAGS;
        booksTags = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                booksTags.add(new BookTag(
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_ID),
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_BOOK),
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_TAG)
                ));
            }
            return booksTags;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BookTag getBookTag(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK_TAGS +
                " WHERE " + DBConst.BOOK_TAGS_COLUMN_ID + " = " + id;
        booksTags = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new BookTag(
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_ID),
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_BOOK),
                        data.getInt(DBConst.BOOK_TAGS_COLUMN_TAG)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createJunction(BookTag bookTag) {
        String query = "INSERT INTO " + DBConst.TABLE_BOOK_TAGS +
                "(" + DBConst.BOOK_TAGS_COLUMN_BOOK + ", " +
                DBConst.BOOK_TAGS_COLUMN_TAG + ") VALUES ('" +
                bookTag.getBook_id() + "', '" + bookTag.getTag_id() + "')";
        System.out.println(query);
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Junction Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BookTagTable getInstance() {
        if(instance == null){
            instance = new BookTagTable();
        }
        return instance;
    }
}
