package com.example.biblionota.Tabs;

import javafx.scene.control.Tab;

public class AddBookTab extends Tab {

    private static AddBookTab instance;

    private AddBookTab(){
        this.setText("Add Book");
    }




    public static AddBookTab getInstance(){
        if(instance == null){
            instance = new AddBookTab();
        }
        return instance;
    }
}
