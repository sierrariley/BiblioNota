package com.example.biblionota.Tabs;

import javafx.scene.control.Tab;

public class RemoveBookTab extends Tab {
    private static RemoveBookTab instance;

    private RemoveBookTab(){
        this.setText("Remove Book");
        







    }

    public static RemoveBookTab getInstance(){
        if(instance == null){
            instance = new RemoveBookTab();
        }
        return instance;
    }
}
