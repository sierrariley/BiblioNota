package com.example.biblionota.database;

import java.io.*;

/**
 * Constants used to log into database
 */
public class Const {

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

