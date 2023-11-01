package com.example.biblionota;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        //Create background Image
        Image background = new Image("images/background.jpg");
        Image background2 = new Image("images/colour.jpg");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
        root.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));
        //Logo image
        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(300);
        logo.setFitWidth(400);

        TextField user = new TextField();
        user.setMaxWidth(300);
        TextField password = new TextField();





        root.setBottom(user);
        root.setCenter(logo);

        Scene scene = new Scene(root, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        stage.setTitle("BiblioNota");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}