package com.example.jattdamukabla;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group g = new Group();
        Scene scene = new Scene(g, Color.PINK);
        stage.setScene(scene);
        stage.setTitle("Rand Console");
        stage.setFullScreenExitHint("Esc daba rand");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("j"));

        stage.setFullScreen(true);
        stage.show();
    }
}