package com.example.packman;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class firstpage_controller {
    @FXML
    private Pane FirstPage ;
    @FXML
    public void Map2_Enter(MouseEvent event)throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("map2.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

            stage.setScene(new Scene(root));
    }
    @FXML
    public void Map1_Enter(MouseEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("map1.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
    }
}
