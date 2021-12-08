package com.example.s3assignment2.controller;

import com.example.s3assignment2.ApiUtility.ApiUtility;
import com.example.s3assignment2.ApiUtility.SceneChanger;
import com.example.s3assignment2.model.ApiResponse;
import com.example.s3assignment2.model.FdaFoodRecall;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class SearchViewController implements Initializable {

    @FXML
    private TableColumn<FdaFoodRecall, String> cityColumn;

    @FXML
    private TableColumn<FdaFoodRecall, String> dateColumn;

    @FXML
    private TableColumn<FdaFoodRecall, String> descriptionColumn;

    @FXML
    private TableView<FdaFoodRecall> initialRecallDataTableView;

    @FXML
    private TableColumn<FdaFoodRecall, String> productTypeColumn;

    @FXML
    private TableColumn<FdaFoodRecall, String> quantityColumn;

    @FXML
    private TableColumn<FdaFoodRecall, String> reasonRecallColumn;


    @FXML
    private TableColumn<FdaFoodRecall, String> statusColumn;
/*
    @FXML
    private ListView<FdaFoodRecall> initialMovieDataListView;
*/
    @FXML
    private Label errMsgLabel;

    @FXML
    private Spinner<Integer> rowSpinner;

    @FXML
    private Label rowCountlabel;


    TextField spinnerEditor;

    String city = null;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errMsgLabel.setVisible(false);
        rowCountlabel.setVisible(false);
        //configure the spinner
        SpinnerValueFactory<Integer> gradeFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 15);
        rowSpinner.setValueFactory(gradeFactory);
        rowSpinner.setEditable(true);
         spinnerEditor = rowSpinner.getEditor();
        spinnerEditor.textProperty().addListener((observableValue, oldValue, newValue)->
        {
            try {
                Integer.parseInt(newValue);
            } catch (NumberFormatException e)
            {
                spinnerEditor.setText(oldValue);
            }
        });

    }

    @FXML
    private void getSearchResults() throws IOException, InterruptedException {

        errMsgLabel.setVisible(false);

        dateColumn.setCellValueFactory(new PropertyValueFactory<>("recall_initiation_date"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("product_description"));
        cityColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        reasonRecallColumn.setCellValueFactory(new PropertyValueFactory<>("reason_for_recall"));
        quantityColumn.setCellValueFactory( new PropertyValueFactory<>("product_quantity"));
        productTypeColumn.setCellValueFactory(new PropertyValueFactory<>("product_type"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        initialRecallDataTableView.getItems().addAll(ApiUtility.getRecallDetailsFromFDA(String.valueOf(spinnerEditor.getText())));
        rowCountlabel.setVisible(true);
        rowCountlabel.setText("No of Rows: " + initialRecallDataTableView.getItems().stream().count());
    }


    @FXML
    private void getDetails(ActionEvent event)   {

        if (initialRecallDataTableView.getSelectionModel().getSelectedItem() != null) {
            try {
                city = initialRecallDataTableView.getSelectionModel().getSelectedItem().getCity();
                SceneChanger.changeScenes(event, "recall-details-view.fxml", city, "Details Recall View - Assignment 2");
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        else
        {errMsgLabel.setVisible(true);
            errMsgLabel.setText("Please Select Record To see Details");

        }

    }

}
