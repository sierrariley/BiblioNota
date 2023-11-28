package com.example.biblionota.Panes;

import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.DatabaseBook;
import com.example.biblionota.tables.BookTable;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class RemoveBookPane {

    public int search(ArrayList<?> list, int id){
        ArrayList<DatabaseBook> searchList = (ArrayList<DatabaseBook>) ((ArrayList<?>) list);
        for(int i = 0; i < searchList.size(); i++){
            if(searchList.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

    public RemoveBookPane(Book book) {
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        BookTable bookTable = BookTable.getInstance();


        Label bookName = new Label("Book Name:");
        ComboBox<Book> comboName = new ComboBox<>();
        ArrayList<Book> bookArrayList = bookTable.getAllBooks();
        comboName.setItems(
                FXCollections.observableArrayList(bookArrayList)
        );


        comboName.getSelectionModel().select(search(bookArrayList, Integer.parseInt(book.getName())));
        grid.add(comboName, 0, 1);
        grid.add(bookName, 0, 0);

        root.setCenter(grid);

    }
}
