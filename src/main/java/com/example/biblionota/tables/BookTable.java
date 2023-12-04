package com.example.biblionota.tables;

import com.example.biblionota.dao.BookDAO;
import com.example.biblionota.database.DBConst;
import com.example.biblionota.database.Database;
import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.BookAuthor;
import com.example.biblionota.pojo.DisplayBook;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * BookTable Class Implements BookDAO
 */
public class BookTable implements BookDAO {
    private static BookTable instance;
    Database db;
    ArrayList<Book> books;

    private BookTable() { db = Database.getInstance(); }

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
                "(" +
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
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int id) {
        //Delete from books_authors where id = xxx
        String query1 = "DELETE FROM " + DBConst.TABLE_BOOK_AUTHOR + " WHERE " +
                DBConst.BOOK_AUTHOR_COLUMN_ID + " = " + id;
        //Delete from books_tags where id = xxx
        String query2 = "DELETE FROM " + DBConst.TABLE_BOOK_TAGS + " WHERE " +
                DBConst.BOOK_TAGS_COLUMN_ID + " = " + id;
        //Delete from books where id = xxx
        String query3 = "DELETE FROM " + DBConst.TABLE_BOOK + " WHERE " +
                DBConst.BOOK_COLUMN_ID + " = " + id;
        System.out.println(query3);
        try {
            db.getConnection().createStatement().execute(query1);
            System.out.println("Deleted books_authors instance");
            db.getConnection().createStatement().execute(query2);
            System.out.println("Deleted books_tags instance");
            db.getConnection().createStatement().execute(query3);
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

    /**
     * Get displayBooks
     * @return
     */
    public ArrayList<DisplayBook> getDisplayBooks() {
        ArrayList<DisplayBook> books = new ArrayList<>();
        String query = """
                SELECT
                 books.id,
                 books.name,
                 books.isbn,
                 books.pages,
                 books.date_started,
                 books.date_finished,
                 genres.name AS genre_name,
                 formats.type AS format_name,
                 reviews.description AS review_description,
                 reviews.star_rating AS review_star_rating,
                 GROUP_CONCAT(DISTINCT authors.name) AS author_names,
                 GROUP_CONCAT(DISTINCT tags.name) AS tag_names
                FROM books
                JOIN genres ON books.genre = genres.id
                JOIN formats ON books.format = formats.id
                LEFT JOIN reviews ON books.review = reviews.id
                LEFT JOIN books_authors ON books.id = books_authors.book_id
                LEFT JOIN authors ON books_authors.author_id = authors.id
                LEFT JOIN books_tags ON books.id = books_tags.book_id
                LEFT JOIN tags ON books_tags.tag_id = tags.id
                GROUP BY books.id, books.name, books.isbn, books.pages, books.date_started, books.date_finished, genres.name, formats.type, reviews.description, reviews.star_rating
                ORDER BY books.id ASC
                """;
        try {
            Statement getDisplayItems = db.getConnection().createStatement();
            ResultSet data = getDisplayItems.executeQuery(query);
            while(data.next()) {
                books.add(new DisplayBook(
                        data.getInt("id"),
                        data.getString("name"),
                        data.getInt("isbn"),
                        data.getInt("pages"),
                        data.getString("date_started"),
                        data.getString("date_finished"),
                        data.getString("genre_name"),
                        data.getString("format_name"),
                        data.getString("review_description"),
                        data.getInt("review_star_rating"),
                        data.getString("author_names"),
                        new String[]{data.getString("tag_names")}
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    /**
     * Get genre count
     * used for creating graphs
     * @param book
     * @return
     */
    public int getGenreCount(int book) {
        int count = -1;
        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT COUNT( " + DBConst.BOOK_COLUMN_NAME +
                            ") as num_genre " +
                            "FROM " + DBConst.TABLE_BOOK +
                            " WHERE " + DBConst.BOOK_COLUMN_GENRE +
                            " = '" + book + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.next();
            count = data.getInt("num_genre");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Get formatCount used for creating graphs
     * @param book
     * @return
     */
    public int getFormatCount(int book) {
        int count = -1;

        try {
            PreparedStatement getCount = db.getConnection()
                    .prepareStatement("SELECT COUNT( " + DBConst.BOOK_COLUMN_NAME +
                                    ") as num_format " +
                                    "FROM " + DBConst.TABLE_BOOK +
                                    " WHERE " + DBConst.BOOK_COLUMN_FORMAT +
                                    " = '" + book + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.next();
            count = data.getInt("num_format");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    /**
     * Unused
     * @return
     */
    public int[] getPageCounts() {
        int[] pageCounts = {};

        try {
            PreparedStatement getCounts = db.getConnection().prepareStatement(
                    "SELECT " + DBConst.BOOK_COLUMN_PAGES + " FROM " + DBConst.TABLE_BOOK);
            ResultSet data = getCounts.executeQuery();
            data.next();
            //Take book pages, group by value. Count the numbers.
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pageCounts;
    }
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