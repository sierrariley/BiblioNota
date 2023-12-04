package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.DisplayBook;
import com.example.biblionota.tables.AuthorTable;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MyBooksTab extends Tab {
    private static MyBooksTab instance;

    public TableView tableview;

    /**
     * Java Doc comments here
     */
    private MyBooksTab(){
        this.setText("My Books");
        BorderPane root = new BorderPane();
        BookTable book = BookTable.getInstance();
        AuthorTable author = AuthorTable.getInstance();
        GenreTable genre = GenreTable.getInstance();

        /**
         * Creates a table to hold the books
         * TableView()
         * TableColumn<>
         */
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
        column6.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getGenre_name()));

        //format
        TableColumn<DisplayBook, String> column7 = new TableColumn<>("Format");
        column7.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getFormat_name()));

        //review
        TableColumn<DisplayBook, String> column8 = new TableColumn<>("Review");
        column8.setCellFactory(table ->{
            TableCell<DisplayBook, String> cell = new TableCell<>();
            Text review = new Text();
            cell.setGraphic(review);
            review.setWrappingWidth(200);
            review.textProperty().bind(cell.itemProperty());
            return cell;
        });
        column8.setCellValueFactory(e-> new SimpleStringProperty(e.getValue().getReview_description()));


        //star rating
        TableColumn<DisplayBook, String> column9 = new TableColumn<>("Star Rating (1-5)");
        column9.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getReview_star_rating())));

        //authors
        TableColumn<DisplayBook, String> column10 = new TableColumn<>("Author(s)");
        column10.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getAuthor_names())));

        //tags
        TableColumn<DisplayBook, String> column11 = new TableColumn<>("Tags");
        column11.setCellValueFactory(e-> new SimpleStringProperty(String.valueOf(e.getValue().getTag_names())));



        //This allows the book to be deleted from table when button is pressed
        Button removeBook = new Button("Delete Book");
        removeBook.setOnAction(e -> {
            DisplayBook remove = (DisplayBook) tableview.getSelectionModel().getSelectedItem();
            System.out.println(remove.getId());
            book.deleteBook(remove.getId());
            refreshTable();
            System.out.println();
        });
        root.setBottom(removeBook);


        tableview.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11);
        tableview.getItems().addAll(book.getDisplayBooks());
        root.setCenter(tableview);

        this.setContent(root);

    }

    /**
     * refreshTable() - clears the table once a book has been delete, and then repopulates with the updated table
     * minus the deleted book
     */
    public void refreshTable(){
        BookTable book = BookTable.getInstance();
        tableview.getItems().clear();
        tableview.getItems().addAll(book.getDisplayBooks());
    }


    public static MyBooksTab getInstance(){
        if(instance == null){
            instance = new MyBooksTab();
        }
        return instance;
    }
}

