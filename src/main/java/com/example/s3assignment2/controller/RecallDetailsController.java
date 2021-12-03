package com.example.s3assignment2.controller;

import com.example.s3assignment2.ApiUtility.ApiUtility;
import com.example.s3assignment2.ApiUtility.SceneChanger;
import com.example.s3assignment2.InitializeFDARecall;

import com.example.s3assignment2.model.FdaFoodRecall;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class RecallDetailsController implements InitializeFDARecall {

    @FXML
    private Label Add1Label;

    @FXML
    private Label Add2Label;

    @FXML
    private Label productQuantityLabel;

    @FXML
    private Label centerClassificationDateLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label codeInfoLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label distributionPatternLabel;

    @FXML
    private Label eventIdLabel;

    @FXML
    private Label firmNotiInitialLabel;

    @FXML
    private Label moreCodeInfoLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private TextArea productDescriptionArea;

    @FXML
    private Label productTypeLabel;

    @FXML
    private TextArea reasonFroRecallArea;

    @FXML
    private Label recallFirmLabel;

    @FXML
    private Label recallInitiationDateLabel;

    @FXML
    private Label recallNumberLabel;

    @FXML
    private Label reportDateLabel;

    @FXML
    private Label stateLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label voluntaryMandatedLabel;

    @Override
    public void loadFDARecallDetails(String recallNumber) throws IOException, InterruptedException {
        FdaFoodRecall fdaFoodRecall = null;
        try {
            fdaFoodRecall = ApiUtility.getRecallDetailsByRecallNumber(recallNumber);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

//        System.out.println(fdaFoodRecall);
        assert fdaFoodRecall != null;
        codeInfoLabel.setText(fdaFoodRecall.getMore_code_info());
        reportDateLabel.setText(fdaFoodRecall.getReport_date());
        statusLabel.setText(fdaFoodRecall.getStatus());
        centerClassificationDateLabel.setText(fdaFoodRecall.getCenter_classification_date());
        voluntaryMandatedLabel.setText(fdaFoodRecall.getVoluntary_mandated());
        distributionPatternLabel.setText(fdaFoodRecall.getDistribution_pattern());
        productQuantityLabel.setText(fdaFoodRecall.getProduct_quantity());
        recallFirmLabel.setText(fdaFoodRecall.getRecall_firm());
        Add1Label.setText(fdaFoodRecall.getAddress_1());
        Add2Label.setText(fdaFoodRecall.getAddress_2());
        recallNumberLabel.setText(fdaFoodRecall.getRecall_firm());
        recallNumberLabel.setText(fdaFoodRecall.getRecall_number());
        firmNotiInitialLabel.setText(fdaFoodRecall.getInitial_firm_notification());
        cityLabel.setText(fdaFoodRecall.getCity());
        stateLabel.setText(fdaFoodRecall.getState());
        eventIdLabel.setText(fdaFoodRecall.getEvent_id());
        postalCodeLabel.setText(fdaFoodRecall.getPostal_code());
        recallInitiationDateLabel.setText(fdaFoodRecall.getRecall_initiation_date());
        productDescriptionArea.setText(fdaFoodRecall.getProduct_description());
        reasonFroRecallArea.setText(fdaFoodRecall.getReason_for_recall());
        productTypeLabel.setText(fdaFoodRecall.getProduct_type());
        countryLabel.setText(fdaFoodRecall.getCountry());
        moreCodeInfoLabel.setText(fdaFoodRecall.getMore_code_info());
    }

    @FXML
    private void backToHome(ActionEvent event) {
        try {
            SceneChanger.changeScene(event, "search-view.fxml");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
