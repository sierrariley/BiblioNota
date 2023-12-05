package com.example.biblionota.tables;

import com.example.biblionota.dao.BookAuthorDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Author;
import com.example.biblionota.pojo.BookAuthor;
import com.example.biblionota.pojo.BookTag;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookAuthorTable implements BookAuthorDAO {
    private static BookAuthorTable instance;
    Database db;
    ArrayList<BookAuthor> booksAuthors;

    private BookAuthorTable() { db = Database.getInstance(); }
    @Override
    /**
     * Insert Statement that grabs all books in table
     */
    public ArrayList<BookAuthor> getAllBookAuthor() {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK_AUTHOR;
        booksAuthors = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                booksAuthors.add(new BookAuthor(
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_ID),
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_BOOK),
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_AUTHOR)
                ));
            }
            return booksAuthors;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    /**
     * Gives book author by id
     * @param id
     */
    public BookAuthor getBookAuthor(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK_AUTHOR +
                " WHERE " + DBConst.BOOK_AUTHOR_COLUMN_ID + " = " + id;
        booksAuthors = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new BookAuthor(
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_ID),
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_BOOK),
                        data.getInt(DBConst.BOOK_AUTHOR_COLUMN_AUTHOR)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This was needed when creating a book
     * Because we have a junction table, this method is used to pass those ids to the book
     * @param bookAuthor
     */
    public void createJunction(BookAuthor bookAuthor) {
        String query = "INSERT INTO " + DBConst.TABLE_BOOK_AUTHOR +
                "(" + DBConst.BOOK_AUTHOR_COLUMN_BOOK + ", " +
                DBConst.BOOK_AUTHOR_COLUMN_AUTHOR + ") VALUES ('" +
                bookAuthor.getBook_id() + "', '" + bookAuthor.getAuthor_id() + "')";
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Junction Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static BookAuthorTable getInstance() {
        if(instance == null){
            instance = new BookAuthorTable();
        }
        return instance;
    }
}
