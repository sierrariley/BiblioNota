package com.example.biblionota.Tabs;

import com.example.biblionota.pojo.Book;
import com.example.biblionota.pojo.DatabaseBook;
import com.example.biblionota.tables.*;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class UpdateBookTab extends Tab {

    public static UpdateBookTab instance;

    /**
     * This is used to locate the index of  a book in a list
     * @param arrayList  list of books to search
     * @param id the desired id of an item in a list
     * @return
     */
    public int find(ArrayList<?> arrayList, int id){
        ArrayList<DatabaseBook> search = (ArrayList<DatabaseBook>) ((ArrayList<?>) arrayList);
        for(int i = 0; i < search.size(); i++){
            if(search.get(i).getId() == id){
                return i;
            }
        }
        return 0;
    }

    private UpdateBookTab(){
        BookTable bookTable = BookTable.getInstance();
        AuthorTable authorTable = AuthorTable.getInstance();
        GenreTable genreTable = GenreTable.getInstance();
        ReviewTable reviewTable = ReviewTable.getInstance();
        TagTable tagTable = TagTable.getInstance();


    }

    public static UpdateBookTab getInstance(){
        if(instance == null){
            instance = new UpdateBookTab();
        }
        return instance;
    }

}
