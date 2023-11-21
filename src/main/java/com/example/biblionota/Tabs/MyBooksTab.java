package com.example.biblionota.Tabs;

import com.example.biblionota.tables.AuthorTable;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;

public class MyBooksTab extends Tab {
    private static MyBooksTab instance;

    private MyBooksTab(){
        this.setText("My Books");

        BookTable book = BookTable.getInstance();
        AuthorTable author = AuthorTable.getInstance();
        GenreTable genre = GenreTable.getInstance();










    }


    public static MyBooksTab getInstance(){
        if(instance == null){
            instance = new MyBooksTab();
        }
        return instance;
    }
}

