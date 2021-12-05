module com.example.s3assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires  java.net.http;
    requires com.jfoenix;

    exports com.example.s3assignment2.controller;
    exports com.example.s3assignment2.model;
    opens com.example.s3assignment2.controller to javafx.fxml;
    opens com.example.s3assignment2.model;
    opens com.example.s3assignment2;
}