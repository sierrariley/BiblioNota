package com.example.biblionota.Panes;

import com.example.biblionota.HelloApplication;
import com.example.biblionota.Scenes.HomeScene;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * This pane provides a login for the user
 * Connects to their database, creates tables
 */
public class LoginPane extends BorderPane {
    public LoginPane(){
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

        TextField user = new TextField();
        user.setMaxWidth(300);
        TextField password = new TextField();
        password.setMaxWidth(300);

        Text userText = new Text("Username:");
        Text passwordText = new Text("Password:");

        //Place Items on Page
        grid.add(user,1,1);
        grid.add(password, 1,2);
        grid.add(userText,0,1);
        grid.add(passwordText,0,2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 0,3);
        loginButton.setOnMouseClicked(e->{
            HelloApplication.mainStage.setScene(new HomeScene());
        });

//        FadeTransition fade = new FadeTransition(Duration.millis(5000));
//        fade.setCycleCount(1000);
//        fade.setFromValue(10);
//        fade.setToValue(0.1);
//        fade.setAutoReverse(true);





        logo.setTranslateX(380);
        logo.setTranslateY(150);
        this.setTop(logo);
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setTranslateY(100);
        grid.setTranslateX(-48);
        this.setCenter(grid);



    }


}
