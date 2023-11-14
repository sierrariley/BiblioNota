package com.example.biblionota.Tabs;

import javafx.scene.control.Tab;

public class MyBooksTab extends Tab {
    private static MyBooksTab instance;

    private MyBooksTab(){
        this.setText("My Books");








    }


    public static MyBooksTab getInstance(){
        if(instance == null){
            instance = new MyBooksTab();
        }
        return instance;
    }
}

