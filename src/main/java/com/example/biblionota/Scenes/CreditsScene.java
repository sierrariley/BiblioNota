package com.example.biblionota.Scenes;

import com.example.biblionota.Constants;
import com.example.biblionota.Panes.CreditsPane;
import com.example.biblionota.Panes.HomePage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CreditsScene extends Scene {
    public CreditsScene() {
        super(new CreditsPane(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    }
}
