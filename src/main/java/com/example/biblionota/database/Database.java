package com.example.biblionota.database;
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
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Fix this next line - base it off of login
        connection = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME + "?serverTimezone=UTC", DB_USER, DB_PASS);
            System.out.println("Created Connection");

            //create test connection button
            //createtables() <- make tables here

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

        //look in database for table that matches tableName param
        ResultSet resultSet = metaData.getTables("srileyjava", null, tableName, null);
        if(resultSet.next()){
            System.out.println(tableName + " table already exists");
        }else{
            createTable = connection.createStatement();
            createTable.execute(tableQry);
            System.out.println(tableName + " table has been created!");

            //INSERT statements go here.
        }
    }

    public Connection getConnection(){return connection;}


}
