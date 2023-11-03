package com.example.biblionota.database;

public class DBConst {
    //Where tables are created

    //Book Table
    public static final String TABLE_BOOK = "book";
    public static final String BOOK_COLUMN_ID = "id";
    public static final String BOOK_COLUMN_NAME = "name";
    public static final String BOOK_COLUMN_ISBN = "isbn";
    public static final String BOOK_COLUMN_PAGES = "pages";


    //Dates Table
    public static final String TABLE_DATE = "date";
    public static final String DATE_COLUMN_STARTED = "date_started";
    public static final String DATE_COLUMN_FINISHED = "date_finished";

    //Review Table
    public static final String TABLE_REVIEW = "review";
    public static final String REVIEW_COLUMN_TAGS = "custom_tags";
    public static final String REVIEW_COLUMN_DESC = "review_description";
    public static final String REVIEW_COLUMN_STARS = "star_rating";

    //Format table
    public static final String TABLE_FORMAT = "format";
    public static final String FORMAT_COLUMN_ID = "id";
    public static final String FORMAT_COLUMN_TYPE = "type";


    //Genre Table
    public static final String TABLE_GENRE = "genre_type";
    public static final String GENRE_COLUMN_ID = "id";
    public static final String GENRE_COLUMN_NAME = "genre";

    //Author Table
    public static final String TABLE_AUTHOR = "author";
    public static final String AUTHOR_COLUMN_ID = "id";
    public static final String AUTHOR_COLUMN_NAME = "name";

    //TODO: Create Table Statements










}
