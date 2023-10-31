module com.example.biblionota {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biblionota to javafx.fxml;
    exports com.example.biblionota;
}