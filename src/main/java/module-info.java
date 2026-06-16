module com.example.packman {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires javafx.media;

    opens com.example.packman to javafx.fxml;
    exports com.example.packman;
}