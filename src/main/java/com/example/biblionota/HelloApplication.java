package com.example.biblionota;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();

        //Create background Image
        Image background = new Image("images/background.jpg");
        Image background2 = new Image("images/colour.jpg");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
        grid.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));
        //Logo image
        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(300);
        logo.setFitWidth(400);

        TextField user = new TextField();
        user.setMaxWidth(300);
        TextField password = new TextField();
        password.setMaxWidth(300);

        Text userText = new Text("Username");
        Text passwordText = new Text("Password");

//        grid.setVgap(5);
//        grid.setHgap(5);

        grid.setAlignment(Pos.CENTER);

        grid.add(logo, 0,0);
        grid.add(user,1,1);
        grid.add(password, 1,2);
        grid.add(userText,0,1);
        grid.add(passwordText,0,2);







        Scene scene = new Scene(grid, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        stage.setTitle("BiblioNota");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}