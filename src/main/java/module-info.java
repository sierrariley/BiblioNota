module com.example.biblionota {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biblionota to javafx.fxml;
    exports com.example.biblionota;
    exports com.example.biblionota.Panes;
    opens com.example.biblionota.Panes to javafx.fxml;
    exports com.example.biblionota.Scenes;
    opens com.example.biblionota.Scenes to javafx.fxml;
}