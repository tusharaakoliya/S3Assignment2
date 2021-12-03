package com.example.s3assignment2.controller;

import com.example.s3assignment2.ApiUtility.ApiUtility;
import com.example.s3assignment2.ApiUtility.SceneChanger;
import com.example.s3assignment2.model.ApiResponse;
import com.example.s3assignment2.model.FdaFoodRecall;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private ListView<FdaFoodRecall> initialMovieDataListView;

    @FXML
    private Label errMsgLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errMsgLabel.setVisible(false);
    }

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {
        errMsgLabel.setVisible(false);
        initialMovieDataListView.getItems().clear();
        ApiResponse apiResponse = ApiUtility.getRecallDetailsFromFDA(searchTextField.getText());
        if (apiResponse != null) {
            initialMovieDataListView.getItems().addAll(apiResponse.getResults());
        }
    }


    @FXML
    private void getDetails(ActionEvent event)   {
        String city = initialMovieDataListView.getSelectionModel().getSelectedItem().getCity();
        System.out.println(city);
        try {
            SceneChanger.changeScenes(event, "recall-details-view.fxml", city);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
