package com.example.biblionota.tables;

import com.example.biblionota.dao.BookDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.BookAuthor;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTable implements BookDAO {
    Database db = Database.getInstance();
    ArrayList<Book> books;
    @Override
    public ArrayList<Book> getAllBooks() {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK;
        books = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                books.add(new Book(
                        data.getInt(DBConst.BOOK_COLUMN_ID),
                        data.getString(DBConst.BOOK_COLUMN_NAME),
                        data.getInt(DBConst.BOOK_COLUMN_ISBN),
                        data.getInt(DBConst.BOOK_COLUMN_PAGES),
                        data.getString(DBConst.BOOK_COLUMN_STARTED),
                        data.getString(DBConst.BOOK_COLUMN_FINISHED),
                        data.getInt(DBConst.BOOK_COLUMN_GENRE),
                        data.getInt(DBConst.BOOK_COLUMN_FORMAT),
                        data.getInt(DBConst.BOOK_COLUMN_REVIEW)
                        ));
            }
            return books;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBook(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_BOOK +
                " WHERE " + DBConst.BOOK_COLUMN_ID + " = " + id;
        books = new ArrayList<>();
        try {
            Statement getTags = db.getConnection().createStatement();
            ResultSet data = getTags.executeQuery(query);
            while (data.next()) {
                return new Book(
                        data.getInt(DBConst.BOOK_COLUMN_ID),
                        data.getString(DBConst.BOOK_COLUMN_NAME),
                        data.getInt(DBConst.BOOK_COLUMN_ISBN),
                        data.getInt(DBConst.BOOK_COLUMN_PAGES),
                        data.getString(DBConst.BOOK_COLUMN_STARTED),
                        data.getString(DBConst.BOOK_COLUMN_FINISHED),
                        data.getInt(DBConst.BOOK_COLUMN_GENRE),
                        data.getInt(DBConst.BOOK_COLUMN_FORMAT),
                        data.getInt(DBConst.BOOK_COLUMN_REVIEW)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createBook(Book book) {
        //TODO
    }

    @Override
    public void updateBook(Book book) {
//TODO
    }

    @Override
    public void deleteBook(int id) {
//TODO
    }
}
