package com.example.biblionota.Panes;

import com.example.biblionota.Tabs.AddBookTab;
import com.example.biblionota.Tabs.MyBooksTab;
import com.example.biblionota.Tabs.RemoveBookTab;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class HomePage extends BorderPane {
    public HomePage() {

        BorderPane root = new BorderPane();


        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(100);
        logo.setFitWidth(300);
        Image background2 = new Image("images/colour.jpg");
//        Image background = new Image("images/background.jpg");
        ImageView imageView = new ImageView(background2);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
//        this.setBackground(new Background(new BackgroundImage(background2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));



        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        Menu credits = new Menu("Credits");
        MenuItem exit = new MenuItem("exit");
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);
        menuBar.getMenus().addAll(fileMenu, credits);


        TabPane tabPane = new TabPane();
        MyBooksTab myBooksTab = MyBooksTab.getInstance();
        AddBookTab addBookTab = AddBookTab.getInstance();
        RemoveBookTab removeBookTab = RemoveBookTab.getInstance();

        tabPane.getTabs().addAll(myBooksTab, addBookTab, removeBookTab);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

//        root.setTop(menuBar);
//        root.setCenter(tabPane);

        this.setCenter(tabPane);
        this.setTop(menuBar);

//        this.add(logo, 1000,0);
//        this.add(tabPane, 0, 1);














    }


}
