package com.example.biblionota;

import com.example.biblionota.Scenes.HomeScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Stage mainStage;
    @Override
    public void start(Stage stage) throws IOException {

        mainStage = stage;
        mainStage.setTitle("BiblioNota");
        mainStage.setScene(new HomeScene());
        mainStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}