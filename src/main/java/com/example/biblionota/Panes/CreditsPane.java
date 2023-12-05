package com.example.biblionota.Panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 * Credits Pane
 */
public class CreditsPane extends StackPane {

    public CreditsPane() {
        //Credits Menu
        getStylesheets().add("main.css");

        VBox vBox = new VBox();
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();

        Label authorTitle = new Label("Authors: ");
        Label authors = new Label("Sage Lawrence & Sierra Riley");

        Label licenseTitle = new Label("License: ");
        Label license = new Label("Copyright 2023 - All Rights Reserved");

        Label assetsTitle = new Label("Assets Acquired: ");
        Label assets = new Label("Assets created using Canva.");

        Label freepik = new Label("Background Image from Freepik.com");

        authorTitle.getStyleClass().add("label");
        authors.getStyleClass().add("label");
        licenseTitle.getStyleClass().add("label");
        license.getStyleClass().add("label");
        assetsTitle.getStyleClass().add("label");
        assets.getStyleClass().add("label");
        freepik.getStyleClass().add("label");
        vBox.getStyleClass().add("root");


        hBox1.getChildren().addAll(authorTitle, authors);
        hBox2.getChildren().addAll(licenseTitle, license);
        hBox3.getChildren().addAll(assetsTitle, assets);
        hBox4.getChildren().add(freepik);

        vBox.getChildren().addAll(hBox1, hBox2, hBox3, hBox4);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(0, 0, 0, 200));


        this.getChildren().add(vBox);
    }
}
