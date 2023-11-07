package com.example.biblionota.database;

public class DBConst {
    //Where tables are created

    //Book Table
    public static final String TABLE_BOOK = "book";
    public static final String BOOK_COLUMN_ID = "book_id";
    public static final String BOOK_COLUMN_NAME = "book_name";
    public static final String BOOK_COLUMN_ISBN = "book_isbn";
    public static final String BOOK_COLUMN_PAGES = "book_pages";
    public static final String BOOK_COLUMN_STARTED = "book_date_started";
    public static final String BOOK_COLUMN_FINISHED = "book_date_finished";
    public static final String BOOK_COLUMN_GENRE = "book_genre";
    public static final String BOOK_COLUMN_FORMAT = "book_format";
    public static final String BOOK_COLUMN_REVIEW = "book_review";

    //Review Table
    public static final String TABLE_REVIEW = "review";
    public static final String REVIEW_COLUMN_ID = "review_id";
    public static final String REVIEW_COLUMN_DESC = "review_description";
    public static final String REVIEW_COLUMN_STARS = "review_star_rating";

    //Tags Table
    public static final String TABLE_TAGS = "tags";
    public static final String TAGS_COLUMN_ID = "tags_id";
    public static final String TAGS_COLUMN_NAME = "name";

    //Book-Tags Junction Table
    public static final String TABLE_BOOK_TAGS = "book_tags";
    public static final String BOOK_TAGS_COLUMN_ID = "book_tags_id";
    public static final String BOOK_TAGS_COLUMN_BOOK = "book_tags_book";
    public static final String BOOK_TAGS_COLUMN_TAG = "book_tags_tag";

    //Format Table
    public static final String TABLE_FORMAT = "format";
    public static final String FORMAT_COLUMN_ID = "format_id";
    public static final String FORMAT_COLUMN_NAME = "type";

    //Genre Table
    public static final String TABLE_GENRE = "genre_type";
    public static final String GENRE_COLUMN_ID = "genre_id";
    public static final String GENRE_COLUMN_NAME = "genre";

    //Book-Author Junction Table
    public static final String TABLE_BOOK_AUTHOR = "books_authors";
    public static final String BOOK_AUTHOR_COLUMN_ID = "books_authors_id";
    public static final String BOOK_AUTHOR_COLUMN_BOOK = "books_authors_book";
    public static final String BOOK_AUTHOR_COLUMN_AUTHOR = "books_authors_author";


    //Author Table
    public static final String TABLE_AUTHOR = "author";
    public static final String AUTHOR_COLUMN_ID = "author_id";
    public static final String AUTHOR_COLUMN_NAME = "name";

    //Create Table Statements
    public static final String CREATE_TABLE_REVIEW =
            "CREATE TABLE " + TABLE_REVIEW + " (" +
            REVIEW_COLUMN_ID + "INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            REVIEW_COLUMN_DESC + "VARCHAR(1000), " +
            REVIEW_COLUMN_STARS + " INT(5));";

    public static final String CREATE_TABLE_TAGS =
            "CREATE TABLE " + TABLE_TAGS + " (" +
            TAGS_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            TAGS_COLUMN_NAME + " VARCHAR(50));";

    public static final String CREATE_TABLE_AUTHOR =
            "CREATE TABLE " + TABLE_AUTHOR + " (" +
            AUTHOR_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            AUTHOR_COLUMN_NAME + " VARCHAR(50));";

    public static final String CREATE_TABLE_GENRE =
            "CREATE TABLE " + TABLE_GENRE + " (" +
            GENRE_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            GENRE_COLUMN_NAME + " VARCHAR(20));";

    public static final String CREATE_TABLE_FORMAT =
            "CREATE TABLE " + TABLE_FORMAT + " (" +
            FORMAT_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            FORMAT_COLUMN_NAME + " VARCHAR(15));";

    public static final String CREATE_TABLE_BOOK_TAGS =
            "CREATE TABLE " + TABLE_BOOK_TAGS + " (" +
                    BOOK_TAGS_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    BOOK_TAGS_COLUMN_BOOK + " INT NOT NULL, " +
                    BOOK_TAGS_COLUMN_TAG + " INT NOT NULL, " +
                    " FOREIGN KEY (" + BOOK_TAGS_COLUMN_TAG + ") " +
                    " REFERENCES " + TABLE_TAGS + "(" + TAGS_COLUMN_ID +"), " +
                    " FOREIGN KEY (" + BOOK_TAGS_COLUMN_BOOK + ") " +
                    " REFERENCES " + TABLE_BOOK + "(" + BOOK_COLUMN_ID +"));";

    public static final String CREATE_TABLE_BOOK_AUTHOR =
            "CREATE TABLE " + TABLE_BOOK_AUTHOR + " (" +
                    BOOK_AUTHOR_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    BOOK_AUTHOR_COLUMN_BOOK + " INT NOT NULL, " +
                    BOOK_AUTHOR_COLUMN_AUTHOR + " INT NOT NULL, " +
                    " FOREIGN KEY (" + BOOK_AUTHOR_COLUMN_BOOK + ") " +
                    " REFERENCES " + TABLE_BOOK + "(" + BOOK_COLUMN_ID +"), " +
                    " FOREIGN KEY (" + BOOK_AUTHOR_COLUMN_AUTHOR + ") " +
                    " REFERENCES " + TABLE_AUTHOR + "(" + AUTHOR_COLUMN_ID +"));";

    public static final String CREATE_TABLE_BOOK =
            "CREATE TABLE " + TABLE_BOOK + " (" +
                    BOOK_COLUMN_ID + " INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
                    BOOK_COLUMN_NAME + " VARCHAR(100), " +
                    BOOK_COLUMN_ISBN + " INT(13), " +
                    BOOK_COLUMN_PAGES + " INT(5), " +
                    BOOK_COLUMN_STARTED + " DATE, " +
                    BOOK_COLUMN_FINISHED + " DATE, " +
                    BOOK_COLUMN_GENRE + " INT NOT NULL, " +
                    BOOK_COLUMN_FORMAT + " INT NOT NULL, " +
                    BOOK_COLUMN_REVIEW + " INT NOT NULL, " +
                    " FOREIGN KEY (" + BOOK_COLUMN_GENRE + ")" +
                    " REFERENCES " + TABLE_GENRE + "(" + GENRE_COLUMN_ID +")," +
                    " FOREIGN KEY (" + BOOK_COLUMN_REVIEW + ")" +
                    " REFERENCES " + TABLE_REVIEW + "(" + REVIEW_COLUMN_ID +")," +
                    " FOREIGN KEY (" + BOOK_COLUMN_FORMAT + ")" +
                    " REFERENCES " + TABLE_FORMAT + "(" + FORMAT_COLUMN_ID +"));";
}
