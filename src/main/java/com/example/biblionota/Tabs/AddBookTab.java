package com.example.biblionota.Tabs;


import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.Tag;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.TagTable;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;



public class AddBookTab extends Tab {

    private static AddBookTab instance;

    private AddBookTab(){
        this.setText("Add Book");
        GridPane root = new GridPane();
        BorderPane pane = new BorderPane();
        ObservableList<Integer> rating = FXCollections.observableArrayList(1, 2, 3, 4, 5);
        ObservableList<String> formatOptions = FXCollections.observableArrayList("Physical", "Audiobook", "Ebook");
        TagTable tagTable = TagTable.getInstance();
        BookTable bookTable = BookTable.getInstance();


        Text bookName = new Text("Book Title: ");
        TextField addBookName = new TextField();
        root.add(bookName, 0, 0);
        root.add(addBookName, 1, 0);


        Text isbn = new Text("ISBN: ");
        TextField fillIsbn = new TextField();
        root.add(isbn, 0, 1);
        root.add(fillIsbn, 1, 1);

        Text pages = new Text("Pages:");
        TextField numPages = new TextField();
        root.add(pages, 0, 2);
        root.add(numPages, 1,2);

        Label startDate = new Label("Date Started: ");
        DatePicker dateStarted = new DatePicker();
        root.add(startDate, 0, 3);
        root.add(dateStarted, 1, 3);

        Label finishDate = new Label("Date Finished: ");
        DatePicker dateFinished = new DatePicker();
        root.add(finishDate, 0, 4);
        root.add(dateFinished, 1, 4);

        Label genre = new Label("Genre: ");
        TextField addGenre = new TextField();
        root.add(genre, 0, 5);
        root.add(addGenre, 1, 5);

        Text format = new Text("Format");
        ComboBox bookFormat = new ComboBox(formatOptions);
        root.add(format, 0, 6);
        root.add(bookFormat, 1, 6);


        Label review = new Label("Review: ");
        TextArea addReview = new TextArea();
        root.add(review, 0, 7);
        root.add(addReview, 1, 7);

        Label starRating = new Label("Star Rating (1-5): ");
        ComboBox bookRating = new ComboBox(rating);
        root.add(starRating, 0, 8);
        root.add(bookRating, 1, 8);

        Label author = new Label("Author: ");
        TextField addAuthor = new TextField();
        root.add(author, 0, 9);
        root.add(addAuthor, 1, 9);


        //TODO:
        Label tag = new Label("Tag: ");
        ListView<Tag> tagName = new ListView<>(FXCollections.observableArrayList(tagTable.getAllTags()));
        TextField addTag = new TextField();
        root.add(tag, 0, 10);
        root.add(addTag, 1,10);
        pane.setRight(tagName);



        Button submit = new Button("Add Book!");
        submit.setOnAction(e ->{
//            Book book = new Book(
//                    book.getId(),
//                    addBookName.getText(),
//                    isbn.getText(),
//                    numPages.getText(),
//                     //TODO: See if this is right
//                     Integer.parseInt(dateStarted.toString()),
//                    Integer.parseInt(dateFinished.toString()),
//                    Integer.parseInt(genre.getText()),
//                     bookFormat.getSelectionModel().getSelectedItem(),
//                    review.getText(),
//                    starRating.getText(),
//                    tagName.getSelectionModel().getSelectedItem().getId(),
//                     Integer.parseInt(author.getText()));

//            bookTable.createBook(book);
            System.out.println("Book added");
        });
        root.add(submit, 0, 11);

        pane.setCenter(root);
        this.setContent(pane);



    }


    public static AddBookTab getInstance(){
        if(instance == null){
            instance = new AddBookTab();
        }
        return instance;
    }
}
