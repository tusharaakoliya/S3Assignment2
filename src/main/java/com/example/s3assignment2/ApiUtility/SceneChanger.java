package com.example.s3assignment2.ApiUtility;

import com.example.s3assignment2.Main;
import com.example.s3assignment2.InitializeFDARecall;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    public static void changeScenes(ActionEvent event, String fxmlFile, String city, String title) throws IOException, InterruptedException {

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        //utilize the InitializeMovie interface to call the loadMovieDetails() method
        InitializeFDARecall controller = fxmlLoader.getController();
        controller.loadFDARecallDetails(city);

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title) throws IOException, InterruptedException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

}
