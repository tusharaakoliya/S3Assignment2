package com.example.s3assignment2.controller;

import com.example.s3assignment2.ApiUtility.ApiUtility;
import com.example.s3assignment2.ApiUtility.SceneChanger;
import com.example.s3assignment2.model.ApiResponse;
import com.example.s3assignment2.model.FdaFoodRecall;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TextField searchTextField;
    @FXML
    private ListView<FdaFoodRecall> initialMovieDataListView;
    @FXML
    private ImageView posterImageView;
    @FXML
    private Label errMsgLabel;
    @FXML
    private Button getDetailsButton;

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
    private void getFDARecallDetails(ActionEvent event) throws IOException, InterruptedException {
        String recallNumber = initialMovieDataListView.getSelectionModel().getSelectedItem().getRecall_number();
        SceneChanger.changeScenes(event, "recall-details-view.fxml", recallNumber);
    }

}
