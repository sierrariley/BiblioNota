package com.example.biblionota.Panes;

import com.example.biblionota.HelloApplication;
import com.example.biblionota.Scenes.CreditsScene;
import com.example.biblionota.Scenes.HomeScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * Credits Pane
 */
public class CreditsPane extends StackPane {

    public CreditsPane() {
        //Style Sheet
        getStylesheets().add("main.css");

        BorderPane pane = new BorderPane();

        //Credits Menu
        VBox vBox = new VBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();

        Label authorTitle = new Label("Authors: ");
        Label authors = new Label("Sage Lawrence & Sierra Riley");

        Label licenseTitle = new Label("License: ");
        Label license = new Label("Copyright 2023 - All Rights Reserved");

        Label assetsTitle = new Label("Assets Acquired: ");
        Label assets = new Label("Assets created using Canva.");

        Label freepik = new Label("Background Image from Freepik.com");

        authorTitle.getStyleClass().add("credit");
        authors.getStyleClass().add("credit");
        licenseTitle.getStyleClass().add("credit");
        license.getStyleClass().add("credit");
        assetsTitle.getStyleClass().add("credit");
        assets.getStyleClass().add("credit");
        freepik.getStyleClass().add("credit");
        vBox.getStyleClass().add("credit");


        hBox1.getChildren().addAll(authorTitle, authors);
        hBox2.getChildren().addAll(licenseTitle, license);
        hBox3.getChildren().addAll(assetsTitle, assets);
        hBox4.getChildren().add(freepik);


        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0, 0, 0, 200));

        Button backButton = new Button("Back");
        backButton.setOnAction(e->{
            HelloApplication.mainStage.setScene(new HomeScene());
        });
        pane.setTop(backButton);



        this.getChildren().addAll(vBox, pane);
    }
}
