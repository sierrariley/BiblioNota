package com.example.biblionota.tables;

import com.example.biblionota.dao.AuthorDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Author;
import com.example.biblionota.pojo.Tag;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AuthorTable implements AuthorDAO {

    private static AuthorTable instance;
    Database db;
    private AuthorTable() { db = Database.getInstance(); }

    ArrayList<Author> authors;
    @Override
    public ArrayList<Author> getAllAuthors() {
        String query = "SELECT * FROM " + DBConst.TABLE_AUTHOR;
        authors = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                authors.add(new Author(
                        data.getInt(DBConst.AUTHOR_COLUMN_ID),
                        data.getString(DBConst.AUTHOR_COLUMN_NAME)
                ));
            }
            return authors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Author getAuthor(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_AUTHOR +
                " WHERE " + DBConst.AUTHOR_COLUMN_ID + " = " + id;
        authors = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Author(
                        data.getInt(DBConst.AUTHOR_COLUMN_ID),
                        data.getString(DBConst.AUTHOR_COLUMN_NAME)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createAuthor(Author author) {
        String query = "INSERT INTO " + DBConst.TABLE_AUTHOR +
                "(" + DBConst.AUTHOR_COLUMN_NAME + ") VALUES ('" +
                author.getName() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AuthorTable getInstance() {
        if(instance == null){
            instance = new AuthorTable();
        }
        return instance;
    }

    @Override
    public void deleteAuthor(int id) {
        //TODO
    }
}
