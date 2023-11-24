package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.DisplayBook;
import com.example.biblionota.tables.AuthorTable;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

public class MyBooksTab extends Tab {
    private static MyBooksTab instance;

    public TableView tableview;
    private MyBooksTab(){
        this.setText("My Books");
        BorderPane root = new BorderPane();
        BookTable book = BookTable.getInstance();
        AuthorTable author = AuthorTable.getInstance();
        GenreTable genre = GenreTable.getInstance();

        tableview = new TableView();
        TableColumn<DisplayBook, String> column1 = new TableColumn<>("Book Name");
        column1.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getName()));

        //isbn
        TableColumn<DisplayBook, String> column2 = new TableColumn<>("ISBN");
        column2.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getIsbn())));

        //pages - int
        TableColumn<DisplayBook, String> column3 = new TableColumn<>("Pages");
        column3.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getPages())));

        //dateStart
        TableColumn<DisplayBook, String> column4 = new TableColumn<>("Date Started");
        column4.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getDate_started()));
        //dateFinish
        TableColumn<DisplayBook, String> column5 = new TableColumn<>("Date Finished");
        column5.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getDate_finished()));

        //genre
        TableColumn<DisplayBook, String> column6 = new TableColumn<>("Genre");
        column6.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getGenre())));

        //format
        TableColumn<DisplayBook, String> column7 = new TableColumn<>("Format");
        column7.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getFormat())));

        //review
        TableColumn<DisplayBook, String> column8 = new TableColumn<>("Review");
        column8.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getReview())));

        tableview.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8);
        tableview.getItems().addAll(book.getDisplayBooks());
        root.setCenter(tableview);





    }


    public static MyBooksTab getInstance(){
        if(instance == null){
            instance = new MyBooksTab();
        }
        return instance;
    }
}

