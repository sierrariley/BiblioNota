package com.example.biblionota.database;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import static com.example.biblionota.database.Const.*;

/**
 * This class is using the Singleton Design pattern. So that the entire application
 * uses one connection to the database.
 * We do this through the use of a private constructor
 * The static method getInstance() will create/return the one instance of the database class
 * Allowing the application to only ever have one instance of the Database class
 */
public class Database {

    private static Database instance;
    private Connection connection = null;

    /**
     * Creates a connection to a Database
     * Will also make tables in Database
     */
    private Database(){
        String[] dbcreds = credentials();
        String DB_NAME = dbcreds[0] + "java";
        String DB_USER = dbcreds[0];
        String DB_PASS = dbcreds[1];

        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Fix this next line - base it off of login
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME + "?serverTimezone=UTC", DB_USER, DB_PASS);
            System.out.println("Created Connection");

            createTable(DBConst.TABLE_AUTHOR, DBConst.CREATE_TABLE_AUTHOR, connection);
            createTable(DBConst.TABLE_FORMAT, DBConst.CREATE_TABLE_FORMAT, connection);
            createTable(DBConst.TABLE_GENRE, DBConst.CREATE_TABLE_GENRE, connection);
            createTable(DBConst.TABLE_TAGS, DBConst.CREATE_TABLE_TAGS, connection);
            createTable(DBConst.TABLE_REVIEW, DBConst.CREATE_TABLE_REVIEW, connection);
            createTable(DBConst.TABLE_BOOK, DBConst.CREATE_TABLE_BOOK, connection);
            createTable(DBConst.TABLE_BOOK_AUTHOR, DBConst.CREATE_TABLE_BOOK_AUTHOR, connection);
            createTable(DBConst.TABLE_BOOK_TAGS, DBConst.CREATE_TABLE_BOOK_TAGS, connection);
            //create test connection button
            //createtables() <- make tables here
            insertTableData();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method will create an instance if one has not been created yet. If so, it will use the instance that has been created
     * @return instance
     */
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    /**
     * This method will create a table, if table is already created, it will tell you
     * @param tableName
     * @param tableQry
     * @param connection
     * @throws SQLException
     */
    private void createTable(String tableName, String tableQry, Connection connection) throws SQLException{
        Statement createTable;
        DatabaseMetaData metaData = connection.getMetaData();
        String[] dbcreds = credentials();
        String DB_NAME = dbcreds[0] + "java";


        //look in database for table that matches tableName param
        ResultSet resultSet = metaData.getTables(DB_NAME, null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }else{
            createTable = connection.createStatement();
            createTable.execute(tableQry);
            System.out.println(tableName + " table has been created!");

        }
    }

    /**
     * Insert statements for tables that need require general content
     * GenreTable, TagTable, FormatTabl
     * users can only choose the populated inserts
     * @throws SQLException
     */
    private void insertTableData() throws SQLException {
        Statement insertStatement = connection.createStatement();

        // Insert values into format, genre, and tags tables
        insertStatement.executeUpdate("INSERT INTO formats VALUES (1, 'Paperback')");
        insertStatement.executeUpdate("INSERT INTO formats VALUES (2, 'Hardcover')");
        insertStatement.executeUpdate("INSERT INTO formats VALUES (3, 'Ebook')");

        insertStatement.executeUpdate("INSERT INTO genres VALUES (1, 'Romance')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (2, 'Memoir')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (3, 'Contemporary')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (4, 'Fantasy')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (5, 'Science Fiction')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (6, 'Magical Realism')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (7, 'Fiction')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (8, 'Young Adult')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (9, 'Satire')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (10, 'Non-Fiction')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (11, 'Thriller')");
        insertStatement.executeUpdate("INSERT INTO genres VALUES (12, 'Biography')");

        insertStatement.executeUpdate("INSERT INTO tags VALUES (1, 'favourites')");
        insertStatement.executeUpdate("INSERT INTO tags VALUES (2, 'no-plot-all-vibes')");
        insertStatement.executeUpdate("INSERT INTO tags VALUES (3, 'books-about-musicians')");
        insertStatement.executeUpdate("INSERT INTO tags VALUES (4, 'has-dragons')");
        insertStatement.executeUpdate("INSERT INTO tags VALUES (5, 'will-make-you-cry')");
        insertStatement.executeUpdate("INSERT INTO tags VALUES (6, 'worst-book-ive-read')");
    }

    public Connection getConnection(){return connection;}


}
