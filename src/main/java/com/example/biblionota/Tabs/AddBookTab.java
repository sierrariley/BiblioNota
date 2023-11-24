package com.example.biblionota.Tabs;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class AddBookTab extends Tab {

    private static AddBookTab instance;

    private AddBookTab(){
        this.setText("Add Book");
        GridPane root = new GridPane();
        ObservableList<Integer> rating = FXCollections.observableArrayList(1, 2, 3, 4, 5);

        BookTable bookTable = BookTable.getInstance();
        AuthorTable authorTable = AuthorTable.getInstance();



        Text bookName = new Text("Book Title: ");
        TextField addBookName = new TextField();
        root.add(bookName, 0, 0);
        root.add(addBookName, 1, 0);



        Text isbn = new Text("ISBN: ");
        TextField fillIsbn = new TextField();
        root.add(isbn, 0, 1);
        root.add(fillIsbn, 1, 1);

        Label author = new Label("Author: ");
        TextField addAuthor = new TextField();
        root.add(author, 0, 2);
        root.add(addAuthor, 1, 2);

        Label genre = new Label("Genre: ");
        TextField addGenre = new TextField();
        root.add(genre, 0, 3);
        root.add(addGenre, 1, 3);

        Label review = new Label("Review: ");
        TextArea addReview = new TextArea();
        root.add(review, 0, 4);
        root.add(addReview, 1, 4);

        Label starRating = new Label("Star Rating (1-5): ");
        ComboBox bookRating = new ComboBox(rating);
        root.add(starRating, 0, 5);
        root.add(bookRating, 1, 5);

        Label tag = new Label("Tag: ");
        TextField addTag = new TextField();
        root.add(tag, 0, 6);
        root.add(addTag, 1, 6);

        Label startDate = new Label("Date Started: ");
        DatePicker dateStarted = new DatePicker();
        root.add(startDate, 0, 7);
        root.add(dateStarted, 1, 7);

        Label finishDate = new Label("Date Finished: ");
        DatePicker dateFinished = new DatePicker();
        root.add(finishDate, 0, 8);
        root.add(dateFinished, 1, 8);

        Button submit = new Button("Add Book!");
        root.add(submit, 0, 9);

        this.setContent(root);








    }





    public static AddBookTab getInstance(){
        if(instance == null){
            instance = new AddBookTab();
        }
        return instance;
    }
}
