package com.example.s3assignment2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Food Recall Details - Assignment 2");
        Image img  = new Image(Objects.requireNonNull(Main.class.getResource("foodsafty.png")).toExternalForm());
        stage.getIcons().add(img);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}