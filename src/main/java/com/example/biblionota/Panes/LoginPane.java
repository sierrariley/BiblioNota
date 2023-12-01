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

public class LoginPane extends GridPane {
    public LoginPane(){
        //Create background Image
        Image background = new Image("images/background.jpg");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
        this.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));

        //Logo image
        ImageView logo = new ImageView(new Image("images/logo.png"));
        logo.setFitHeight(300);
        logo.setFitWidth(400);

        //username
        TextField user = new TextField();
        user.setMaxWidth(300);
        //password
        TextField password = new TextField();
        password.setMaxWidth(300);

        Text userText = new Text("Username");
        Text passwordText = new Text("Password");


        this.setAlignment(Pos.CENTER);
        this.add(logo, 0,0);
        this.add(user,1,1);
        this.add(password, 1,2);
        this.add(userText,0,1);
        this.add(passwordText,0,2);

        //Login button
        Button loginButton = new Button("Login");
        this.add(loginButton, 0,3);
        //Send to HomeScene
        loginButton.setOnMouseClicked(e->{
            //TODO: Validate username and password
            HelloApplication.mainStage.setScene(new HomeScene());
        });
    }
}
