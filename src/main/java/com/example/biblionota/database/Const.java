package com.example.biblionota.database;

import java.io.*;

/**
 * Constants used to log into database
 * Taken from login.txt
 */
public class Const {
    /**
     * This method creates an array that holds the strings in the login.txt file
     * this will then be used for the database connection
     * each index will be given to either DB_NAME, DB_USER or DB_PASS
     * @return dbcreds - A String array of the text in file
     */
    public static String[] credentials(){
        String line;
        String[] dbcreds = new String[3];
        try {
            FileReader readFile = new FileReader("login.txt");
            BufferedReader reader = new BufferedReader(readFile);
            int i = 0;
            while((line = reader.readLine()) != null){
                dbcreds[i++] = line;
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dbcreds;
    }

}

