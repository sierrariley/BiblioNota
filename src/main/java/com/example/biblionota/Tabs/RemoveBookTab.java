package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.DatabaseBook;
import com.example.biblionota.pojo.DisplayBook;
import com.example.biblionota.tables.AuthorTable;
import com.example.biblionota.tables.BookTable;
import com.example.biblionota.tables.GenreTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class RemoveBookTab extends Tab {
    private static RemoveBookTab instance;

    public int search(ArrayList<?> list, int id){
        ArrayList<DatabaseBook> searchList = (ArrayList<DatabaseBook>) ((ArrayList<?>) list);
        for(int i = 0; i < searchList.size(); i++){
            if(searchList.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }


    public TableView tableview;
    private RemoveBookTab(){
        this.setText("Remove Book");
        BorderPane root = new BorderPane();









    }

    public static RemoveBookTab getInstance(){
        if(instance == null){
            instance = new RemoveBookTab();
        }
        return instance;
    }
}
