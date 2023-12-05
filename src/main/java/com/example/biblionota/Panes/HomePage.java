package com.example.biblionota.Panes;

import com.example.biblionota.HelloApplication;
import com.example.biblionota.Scenes.CreditsScene;
import com.example.biblionota.Tabs.AddBookTab;
import com.example.biblionota.Tabs.GraphTab;
import com.example.biblionota.Tabs.MyBooksTab;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * HomePane
 * Holds all the tabs and MenuBar
 */
public class HomePage extends BorderPane {
    public HomePage() {

        //MenuBar Creation
        MenuBar menuBar = new MenuBar();

        //File MenuItem
        Menu fileMenu = new Menu("File");
        MenuItem exit = new MenuItem("exit");
        //Closes the program
        exit.setOnAction(e->{
            System.exit(0);
        });
        fileMenu.getItems().add(exit);

        //Credits MenuItem
        Menu credits = new Menu("Credits");
        MenuItem openCredits = new MenuItem("open");
        credits.getItems().add(openCredits);
        //Opens CreditsScene
        openCredits.setOnAction(e->{
            HelloApplication.mainStage.setScene(new CreditsScene());
        });
        menuBar.getStyleClass().add("menu-bar");

        //Add MenuItems to MenuBar
        menuBar.getMenus().addAll(fileMenu, credits);

        //Create TabPane and getInstances of Tabs
        TabPane tabPane = new TabPane();
        MyBooksTab myBooksTab = MyBooksTab.getInstance();
        AddBookTab addBookTab = AddBookTab.getInstance();
        GraphTab graphTab = GraphTab.getInstance();


        //StyleSheet
        tabPane.getStyleClass().add("tab-pane");
        addBookTab.getStyleClass().add("tab");
        getStylesheets().add("main.css");

        //Add tabs to pane
        tabPane.getTabs().addAll(myBooksTab, addBookTab, graphTab);

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        this.setCenter(tabPane);
        this.setTop(menuBar);
    }
}
