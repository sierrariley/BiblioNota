package com.example.biblionota.tables;

import com.example.biblionota.dao.AuthorDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Author;
import com.example.biblionota.pojo.Tag;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * AuthorTable Class implements AuthorDAO
 */
public class AuthorTable implements AuthorDAO {

    private static AuthorTable instance;
    ArrayList<Author> authors;
    Database db;

    /**
     * Creates instance
     */
    private AuthorTable() { db = Database.getInstance(); }

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

    /**
     * This gives the id of the author object being used
     * @param id
     * @return
     */
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

    /**
     * Creating an author for a book.
     * Insert statement into table
     * @param author
     */
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

    /**
     * Instance of table
     * @return
     */
    public static AuthorTable getInstance() {
        if(instance == null){
            instance = new AuthorTable();
        }
        return instance;
    }

    /**
     * Used to author from a book
     * @param id
     */
    @Override
    public void deleteAuthor(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_AUTHOR + " WHERE " +
                DBConst.AUTHOR_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * When needing to create a author before creating a new id
     * This gives you the last id created
     * @return
     */
    public int getLastId(){
        int id = -1;
        try{
            PreparedStatement getId = db.getConnection().prepareStatement("SELECT last_insert_id() as id");
            ResultSet data = getId.executeQuery();
            data.next();
            id = data.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
