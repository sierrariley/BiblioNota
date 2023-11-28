package com.example.biblionota.Tabs;

import com.example.biblionota.Panes.RemoveBookPane;
import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.DatabaseBook;
import com.example.biblionota.pojo.DisplayBook;
import com.example.biblionota.tables.AuthorTable;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.awt.*;
import java.util.ArrayList;

public class RemoveBookTab extends Tab {
    private static RemoveBookTab instance;




    public TableView tableview;
    private RemoveBookTab() {
        BorderPane root = new BorderPane();
        this.setText("Remove Book");
        BookTable bookTable = BookTable.getInstance();


//        RemoveBookPane pane = new RemoveBookPane();
//
//        root.setCenter(pane);

//        tableview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                if(newValue != null){
//                    Book book = BookTable.getInstance().getBook(((DisplayBook)newValue).getId());
//                    RemoveBookPane pane = new
//                }
//
//            }
//        });


    }


    public static RemoveBookTab getInstance(){
        if(instance == null){
            instance = new RemoveBookTab();
        }
        return instance;
    }
}
