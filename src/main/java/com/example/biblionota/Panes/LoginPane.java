package com.example.biblionota.Panes;

import com.example.biblionota.HelloApplication;
import com.example.biblionota.Scenes.HomeScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This pane provides a login for the user
 * Saves their credentials to a file
 * Connects to their database, creates tables
 */
public class LoginPane extends BorderPane {
    public LoginPane() throws IOException {
        GridPane grid = new GridPane();

        //Create background Image
        Image background = new Image("images/background3.png");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200, 800, true, true, true, false);
        this.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));

        //Logo image
        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(300);
        logo.setFitWidth(400);

        //Login Fields
        Text userText = new Text("Username:");
        final PasswordField passwordField = new PasswordField();
//        passwordField.setOnAction(e ->{
//            if(!passwordField.getText().equals("T2f$Ay!")){
//
//            }
//        });
        Text passwordText = new Text("Password:");
        TextField name = new TextField();
        name.setMaxWidth(300);
        TextField user = new TextField();
        user.setMaxWidth(300);
        TextField password = new TextField();
        password.setMaxWidth(300);

        //Test Connection Button
        Button testConection = new Button("Add Credentials");
        testConection.setOnAction(e -> {
            try {
                String userName = user.getText();
                String passWord = passwordField.getText();
                addToFile("login.txt", userName);
                addToFile("login.txt", passWord);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        //Login Button
        Button loginButton = new Button("Login");
        loginButton.setOnMouseClicked(e -> {
            HelloApplication.mainStage.setScene(new HomeScene());
        });

        //Place Items on Page
        grid.add(userText, 0, 2);
        grid.add(passwordText, 0, 3);
        grid.add(user, 1, 2);
        grid.add(passwordField, 1, 3);
        grid.add(testConection, 0, 4);
        grid.add(loginButton, 0, 5);

        logo.setTranslateX(380);
        logo.setTranslateY(150);
        this.setTop(logo);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setTranslateY(100);
        grid.setTranslateX(-48);
        this.setCenter(grid);

    }

    /**
     *
     * @param filename
     * @param input
     * @throws IOException
     */
    public static void addToFile(String filename, String input) throws IOException {
        FileOutputStream add = new FileOutputStream(filename, true);
        PrintWriter printWriter = new PrintWriter(add);
        printWriter.println(input);
        printWriter.flush();
        printWriter.close();
    }

}


