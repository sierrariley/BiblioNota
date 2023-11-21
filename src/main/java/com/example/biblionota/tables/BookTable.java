package com.example.biblionota.tables;

import com.example.biblionota.dao.BookDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.BookAuthor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookTable implements BookDAO {
    private static BookTable instance;
    Database db;
    private BookTable() { db = Database.getInstance(); }
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
        String query = "INSERT INTO " + DBConst.TABLE_BOOK +
                "(" + DBConst.BOOK_COLUMN_NAME + ", " +
                DBConst.BOOK_COLUMN_NAME + ", " +
                DBConst.BOOK_COLUMN_ISBN + ", " +
                DBConst.BOOK_COLUMN_PAGES + ", " +
                DBConst.BOOK_COLUMN_STARTED + ", " +
                DBConst.BOOK_COLUMN_FINISHED + ", " +
                DBConst.BOOK_COLUMN_GENRE + ", " +
                DBConst.BOOK_COLUMN_FORMAT + ", " +
                DBConst.BOOK_COLUMN_REVIEW + ") VALUES ('" +
                book.getName() + "', '" +
                book.getIsbn() + "', '" +
                book.getPages() + "', '" +
                book.getDate_started() + "', '" +
                book.getDate_finished() + "', '" +
                book.getGenre() + "', '" +
                book.getFormat() + "', '" +
                book.getReview() + "')";

        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBook(Book book) {
        /**
         *     private int isbn;
         *     private int pages;
         *     private String date_started;
         *     private String date_finished;
         *     private int genre;
         *     private int format;
         *     private int review;
         */
        String query = "UPDATE " + DBConst.TABLE_BOOK + " SET " +
                DBConst.BOOK_COLUMN_NAME + "= " + book.getName() + ", " +
                DBConst.BOOK_COLUMN_ISBN + "= " + book.getIsbn() + ", " +
                DBConst.BOOK_COLUMN_PAGES + "= " + book.getPages() + ", " +
                DBConst.BOOK_COLUMN_STARTED + "= " + book.getDate_started() + ", " +
                DBConst.BOOK_COLUMN_FINISHED + "= " + book.getDate_finished() + ", " +
                DBConst.BOOK_COLUMN_GENRE + "= " + book.getGenre() + ", " +
                DBConst.BOOK_COLUMN_FORMAT + "= " + book.getFormat() + ", " +
                DBConst.BOOK_COLUMN_REVIEW + "= " + book.getReview() +
                " WHERE " + DBConst.BOOK_COLUMN_ID + " = " + book.getId();

        try {
            Statement updateItem = db.getConnection().createStatement();
            updateItem.executeUpdate(query);
            System.out.println("Record Updated");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        String query = "DELETE FROM " + DBConst.TABLE_BOOK + " WHERE " +
                DBConst.BOOK_COLUMN_ID + " = " + id;
        try {
            db.getConnection().createStatement().execute(query);
            System.out.println("Deleted Record");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static BookTable getInstance() {
        if(instance == null){
            instance = new BookTable();
        }
        return instance;
    }

    //TODO: Create getDisplayItems
    //TODO: Create getItemCount
}