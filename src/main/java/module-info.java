module com.example.biblionota {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.biblionota to javafx.fxml;
    exports com.example.biblionota;
}