package com.example.biblionota.Scenes;

import com.example.biblionota.Constants;
import com.example.biblionota.Panes.LoginPane;
import javafx.scene.Scene;

import java.io.IOException;

public class LoginScene extends Scene {

    public LoginScene() throws IOException {super(new LoginPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);}
}
