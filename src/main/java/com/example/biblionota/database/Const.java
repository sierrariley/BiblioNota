package com.example.biblionota.database;

import java.io.*;

/**
 * Constants used to log into database
 */
public class Const {
    //TODO: Needs to be update to correspond with a login page
    //Concat username with "java"



//    public static String DB_NAME ;
//    public static String DB_USER ;
//    public static String DB_PASS ;

    //Short Password - thrsvthrsv
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
//    String DB_NAME = dbName;
//    String DB_USER = user;
//    String DB_PASS = pass;
//    System.out.println("DB_NAME: " + DB_NAME);
//    System.out.println("DB_USER: " + DB_USER);
//    System.out.println("DB_PASS: " + DB_PASS);
    return dbcreds;
}

}

