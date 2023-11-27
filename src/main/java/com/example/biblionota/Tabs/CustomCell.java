package com.example.biblionota.Tabs;

import javafx.scene.control.TableCell;

public class CustomCell<T> extends TableCell<T, String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if(item == null){
            setText("");
        }else{
            setText(item);
        }

    }
}
