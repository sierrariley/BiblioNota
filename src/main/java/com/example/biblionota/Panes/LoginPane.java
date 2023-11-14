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
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();

        //Create background Image
        Image background = new Image("images/background.jpg");
        Image background2 = new Image("images/colour.jpg");
        ImageView imageView = new ImageView(background);
        imageView.setPreserveRatio(true);
        BackgroundSize size = new BackgroundSize(1200,800,true,true,true, false);
        this.setBackground(new Background(new BackgroundImage(background, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size)));

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

        this.add(logo, 0,0);
        this.add(user,1,1);
        this.add(password, 1,2);
        this.add(userText,0,1);
        this.add(passwordText,0,2);

        Button loginButton = new Button("Login");
        this.add(loginButton, 0,3);
        loginButton.setOnMouseClicked(e->{
            HelloApplication.mainStage.setScene(new HomeScene());
        });



    }


}
