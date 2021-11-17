module com.example.s3assignment2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.s3assignment2 to javafx.fxml;
    exports com.example.s3assignment2;
}