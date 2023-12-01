package com.example.biblionota.Panes;

import com.example.biblionota.HelloApplication;
import com.example.biblionota.Scenes.HomeScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This pane provides a login for the user
 * Connects to their database, creates tables
 */
public class LoginPane extends BorderPane {
    public LoginPane() throws IOException {
        GridPane grid = new GridPane();

        //Create background Image
        Image background = new Image("images/background3.png");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
        this.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));

        //Logo image
        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(300);
        logo.setFitWidth(400);

        Text userText = new Text("Username:");
        Text passwordText = new Text("Password:");

        //Login Fields
        File fileName = new File("login.txt");

        TextField user = new TextField();
        user.setMaxWidth(300);
        TextField password = new TextField();
        password.setMaxWidth(300);

        //Test Connection Button
        Button testConection = new Button("Test Connection");
        grid.add(testConection, 0, 3);
        testConection.setOnAction(e->{
            try {
                String userName = user.getText();
                String passWord = password.getText();
                addToFile("login.txt", userName);
                addToFile("login.txt", passWord);

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            
        });


        //Login Button
        Button loginButton = new Button("Login");
        grid.add(loginButton, 0,4);
        loginButton.setOnMouseClicked(e->{
//            HelloApplication.mainStage.setScene(new HomeScene());
        });

        //Place Items on Page
        grid.add(user,1,1);
        grid.add(password, 1,2);
        grid.add(userText,0,1);
        grid.add(passwordText,0,2);

        logo.setTranslateX(380);
        logo.setTranslateY(150);
        this.setTop(logo);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setTranslateY(100);
        grid.setTranslateX(-48);
        this.setCenter(grid);

    }

    public static void addToFile(String filename, String input) throws IOException{
        BufferedWriter  add = new BufferedWriter(new BufferedWriter(new FileWriter(filename, true)));
            add.write(input);
            add.newLine();
            add.flush();
            add.close();
    }

}
