package com.example.packman;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {

    @FXML
    private GridPane MAP;
    @FXML
    private Button START ;
    @FXML
    private ImageView gifImageView_1;
    @FXML
    private ImageView gifImageView_2;
    @FXML
    private ImageView gifImageView_3;
    @FXML
    private ImageView gifImageView_4;
    @FXML
    private ImageView gifImageView_0;
    @FXML
    private TextField PointBox;
    @FXML
    private  Button ExitButton;
    @FXML
    private Button BOOSTER ;
    public int zariib = 1 ;

    private MediaPlayer mediaPlayer1;
    private int score = 0 ;
    private packman_killer packman_killer_1 , packman_killer_2,packman_killer_3,packman_killer_4;
    private MediaPlayer mediaPlayer2;
    private Timeline pack_man;
    private Timeline pack_1;
    private Timeline pack_2;
    private Timeline pack_3;
    private Timeline pack_4;
    int speed = 200 ;


    private void move_attacker() {
        pack_1 = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            packman_killer_1.move();
            GridPane.setRowIndex(gifImageView_1, packman_killer_1.getRow());
            GridPane.setColumnIndex(gifImageView_1, packman_killer_1.getCol());
        }));
        pack_1.setCycleCount(Timeline.INDEFINITE);

        pack_2 = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            packman_killer_2.move();
            GridPane.setRowIndex(gifImageView_2, packman_killer_2.getRow());
            GridPane.setColumnIndex(gifImageView_2, packman_killer_2.getCol());
        }));
        pack_2.setCycleCount(Timeline.INDEFINITE);

        pack_3 = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            packman_killer_3.move();
            GridPane.setRowIndex(gifImageView_3, packman_killer_3.getRow());
            GridPane.setColumnIndex(gifImageView_3, packman_killer_3.getCol());
        }));
        pack_3.setCycleCount(Timeline.INDEFINITE);

        pack_4 = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            packman_killer_4.move();
            GridPane.setRowIndex(gifImageView_4, packman_killer_4.getRow());
            GridPane.setColumnIndex(gifImageView_4, packman_killer_4.getCol());
        }));
        pack_4.setCycleCount(Timeline.INDEFINITE);

        pack_1.play();
        pack_2.play();
        pack_3.play();
        pack_4.play();
    }    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScore();
        String gifPath_packman = "file:///C:/Users/amira/intellij_project/packman/packman.gif";
        Image gifImage = new Image(gifPath_packman);
        gifImageView_0.setFitWidth(30);
        gifImageView_0.setFitHeight(30);
        gifImageView_0.setImage(gifImage);

        String gifPath_killer1 = "file:///C:/Users/amira/intellij_project/packman/killer1.gif";
        packman_killer_1 = new packman_killer(MAP ,gifPath_killer1);

        String gifPath_killer2 = "file:///C:/Users/amira/intellij_project/packman/killer2.gif";
        packman_killer_2 = new packman_killer(MAP ,gifPath_killer2);

        String gifPath_killer3 = "file:///C:/Users/amira/intellij_project/packman/killer3.gif";
        packman_killer_3 = new packman_killer(MAP,gifPath_killer3);

        String gifPath_killer4 = "file:///C:/Users/amira/intellij_project/packman/killer4.gif";
        packman_killer_4 = new packman_killer(MAP,gifPath_killer4);

        gifImageView_1 = packman_killer_1.getGifImageView();
        gifImageView_2 = packman_killer_2.getGifImageView();
        gifImageView_3 = packman_killer_3.getGifImageView();
        gifImageView_4 = packman_killer_4.getGifImageView();
        MAP.setFocusTraversable(true);
        MAP.setOnKeyPressed(this::handleKeyPress);
    }

    @FXML
    public void START_CLICK(MouseEvent mouseEvent) {
        BOOSTER.setVisible(true);
        move_attacker();
        PointBox.setVisible(true);
        GridPane.setRowIndex(gifImageView_0,22 );
        GridPane.setColumnIndex(gifImageView_0, 11);
        GridPane.setRowIndex(gifImageView_1, packman_killer_1.getRow());
        GridPane.setColumnIndex(gifImageView_1, packman_killer_1.getCol());
        GridPane.setRowIndex(gifImageView_2, packman_killer_2.getRow());
       GridPane.setColumnIndex(gifImageView_2, packman_killer_2.getCol());
       GridPane.setRowIndex(gifImageView_3, packman_killer_3.getRow());
        GridPane.setColumnIndex(gifImageView_3, packman_killer_3.getCol());
        GridPane.setRowIndex(gifImageView_4, packman_killer_4.getRow());
        GridPane.setColumnIndex(gifImageView_4, packman_killer_4.getCol());

        if (!MAP.getChildren().contains(gifImageView_1)) {
            MAP.getChildren().add(gifImageView_1);
        }
        if (!MAP.getChildren().contains(gifImageView_2)) {
            MAP.getChildren().add(gifImageView_2);
        }
        if (!MAP.getChildren().contains(gifImageView_3)) {
            MAP.getChildren().add(gifImageView_3);
        }
        if (!MAP.getChildren().contains(gifImageView_4)) {
            MAP.getChildren().add(gifImageView_4);
        }
        if (!MAP.getChildren().contains(gifImageView_0)) {
            MAP.getChildren().add(gifImageView_0);
        }

        String audioFilePath1 = "file:///C:/Users/amira/intellij_project/packman/packman.mp3";
        Media media1 = new Media(audioFilePath1);
        mediaPlayer1 = new MediaPlayer(media1);

        String audioFilePath2 = "file:///C:/Users/amira/intellij_project/packman/2.mp3";
        Media media2 = new Media(audioFilePath2);
        mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setCycleCount(MediaPlayer.INDEFINITE);

        mediaPlayer1.setOnEndOfMedia(() -> {
            mediaPlayer2.play();
        });
        int num=0;
        mediaPlayer1.play();
        for (int row = 1; row < 28; row++) {
            for (int col = 1; col < 23; col++) {
                if (getNodeFromGridPane(MAP, col, row) == null) {
                    Color yellow = Color.rgb(200,200,0);
                    if((row+col)%3==0){
                        Circle circle = new Circle(8, yellow);
                        StackPane stackPane = new StackPane(circle);
                        MAP.add(stackPane, col, row);
                        num+=30;
                    }
                    else {
                        Circle circle = new Circle(5, yellow);
                        StackPane stackPane = new StackPane(circle);
                        MAP.add(stackPane, col, row);
                        num+=10;
                    }
                }
            }
        }
        System.out.println(num);
        START.setVisible(false);
        START.setManaged(false);
        MAP.requestFocus();

    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            Integer nodeCol = GridPane.getColumnIndex(node);
            Integer nodeRow = GridPane.getRowIndex(node);

            if (nodeCol != null && nodeCol == col && nodeRow != null && nodeRow == row) {
                return node;
            }
        }
        return null;
    }
    private void handleKeyPress(KeyEvent event) {
        if(check_game_over() == true) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("gameover.fxml"));
                Parent root = loader.load();
                gameover_controller secondPageController = loader.getController();
                secondPageController.label.setText(String.valueOf(score));
                boolean win_lost = true ;
                for (int row = 1; row < 28; row++) {
                    for (int col = 1; col < 23; col++) {
                        Node node = getNodeFromGridPane(MAP, col , row);
                        if (node != null && node instanceof StackPane) {
                            win_lost=false ;
                        }
                    }
                }
                if(win_lost ==true ) {
                    mediaPlayer2.stop();
 //                   String audioFilePath3 = "file:///C:/Users/amira/Downloads/1.mp3";
 //                   Media media1 = new Media(audioFilePath3);
 //                   MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
 //                   mediaPlayer1.play();

                    secondPageController.win_page.setVisible(true);
                }
                else {
                    mediaPlayer2.stop();
//                    String audioFilePath4 = "file:///C:/Users/amira/Downloads/2.mp3";
//                    Media media2 = new Media(audioFilePath4);
//                    MediaPlayer mediaPlayer1 = new MediaPlayer(media2);
//                    mediaPlayer1.play();
                    secondPageController.lost_page.setVisible(true);
                }

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        packman_killer_1.move();
//        packman_killer_2.move();
//        packman_killer_3.move();
//        packman_killer_4.move();
//        GridPane.setRowIndex(gifImageView_1, packman_killer_1.getRow());
//        GridPane.setColumnIndex(gifImageView_1, packman_killer_1.getCol());
//        GridPane.setRowIndex(gifImageView_2, packman_killer_2.getRow());
//        GridPane.setColumnIndex(gifImageView_2, packman_killer_2.getCol());
//        GridPane.setRowIndex(gifImageView_3, packman_killer_3.getRow());
//        GridPane.setColumnIndex(gifImageView_3, packman_killer_3.getCol());
//        GridPane.setRowIndex(gifImageView_4, packman_killer_4.getRow());
//        GridPane.setColumnIndex(gifImageView_4, packman_killer_4.getCol());
        switch (event.getCode()) {
            case D:
                moveRight();
                break;
            case A:
                moveLeft();
                break;
            case S:
                moveDown();
                break;
            case W:
                moveUp();
                break;
            default:
                break;
        }
    }

    private void moveRight() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed), event -> {
            Integer currentColumn = GridPane.getColumnIndex(gifImageView_0);
            Integer currentRow = GridPane.getRowIndex(gifImageView_0);
            if (getNodeFromGridPane(MAP, currentColumn + 1, currentRow) instanceof Rectangle) {
            } else {
                Node node = getNodeFromGridPane(MAP, currentColumn + 1, currentRow);
                if (node != null && node instanceof StackPane) {
                    removeStackPaneFromGridPane(MAP, currentColumn + 1, currentRow);
                    StackPane stackPane = (StackPane) node;
                    Circle circle = (Circle) stackPane.getChildren().get(0);
                    if (circle.getRadius() == 8) {
                        incrementScore(false,zariib);
                    }
                    else {
                        incrementScore(true,zariib);
                    }
                }
                GridPane.setColumnIndex(gifImageView_0, currentColumn + 1);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void moveLeft() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed), event -> {
            Integer currentColumn = GridPane.getColumnIndex(gifImageView_0);
            Integer currentRow = GridPane.getRowIndex(gifImageView_0);
            if (getNodeFromGridPane(MAP, currentColumn - 1, currentRow) instanceof Rectangle || currentColumn <= 1) {
            } else {
                Node node = getNodeFromGridPane(MAP, currentColumn - 1, currentRow);
                if (node != null && node instanceof StackPane) {
                    removeStackPaneFromGridPane(MAP, currentColumn - 1, currentRow);
                    StackPane stackPane = (StackPane) node;
                    Circle circle = (Circle) stackPane.getChildren().get(0);
                    if (circle.getRadius() == 8) {
                        incrementScore(false,zariib);
                    }
                    else {
                        incrementScore(true,zariib);
                    }
                }
                GridPane.setColumnIndex(gifImageView_0, currentColumn - 1);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void moveUp() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed), event -> {
            Integer currentRow = GridPane.getRowIndex(gifImageView_0);
            Integer currentColumn = GridPane.getColumnIndex(gifImageView_0);
            if (getNodeFromGridPane(MAP, currentColumn, currentRow - 1) instanceof Rectangle || currentRow <= 1) {
            } else {
                Node node = getNodeFromGridPane(MAP, currentColumn, currentRow - 1);
                if (node != null && node instanceof StackPane) {
                    removeStackPaneFromGridPane(MAP, currentColumn, currentRow - 1);
                    StackPane stackPane = (StackPane) node;
                    Circle circle = (Circle) stackPane.getChildren().get(0);
                    if (circle.getRadius() == 8) {
                        incrementScore(false,zariib);
                    }
                    else {
                        incrementScore(true,zariib);
                    }
                }
                GridPane.setRowIndex(gifImageView_0, currentRow - 1);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void moveDown() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(speed), event -> {
            Integer currentRow = GridPane.getRowIndex(gifImageView_0);
            Integer currentColumn = GridPane.getColumnIndex(gifImageView_0);
            if (getNodeFromGridPane(MAP, currentColumn, currentRow + 1) instanceof Rectangle) {
            } else {
                Node node = getNodeFromGridPane(MAP, currentColumn, currentRow + 1);
                if (node != null && node instanceof StackPane) {
                    removeStackPaneFromGridPane(MAP, currentColumn, currentRow + 1);
                    StackPane stackPane = (StackPane) node;
                    Circle circle = (Circle) stackPane.getChildren().get(0);
                    if (circle.getRadius() == 8) {
                        incrementScore(false,zariib);
                    }
                    else {
                        incrementScore(true,zariib);
                    }
                }
                GridPane.setRowIndex(gifImageView_0, currentRow + 1);
            }
        }));
        timeline.setCycleCount(1);
        timeline.play();
    }
    private void incrementScore(boolean a , int zariib) {
//        String audioFilePath3 = "file:///C:/Users/amira/Downloads/3.mp3";
//        Media media4 = new Media(audioFilePath3);
//        MediaPlayer mediaPlayer1 = new MediaPlayer(media4);
 //       mediaPlayer1.play();
        if(a){
            score += (zariib*10);
            updateScore();
        }
        if(!a){
            score += (zariib*30);
            updateScore();
        }
    }
    private void updateScore() {
        PointBox.setText("Score: " + score);
    }
    private void removeStackPaneFromGridPane(GridPane gridPane, int col, int row) {
        Node node = getNodeFromGridPane(gridPane, col, row);
        if (node != null && node instanceof StackPane) {
            gridPane.getChildren().remove(node);
        }
    }
    private boolean check_game_over(){
        int currentRow = GridPane.getRowIndex(gifImageView_0);
        int  currentColumn = GridPane.getColumnIndex(gifImageView_0);
        if(currentRow == packman_killer_1.getRow() && currentColumn==packman_killer_1.getCol()){
            mediaPlayer2.stop();
            return true ;
        }
        if(currentRow == packman_killer_2.getRow() && currentColumn==packman_killer_2.getCol()){
            mediaPlayer2.stop();
            return true ;
        }
        if(currentRow == packman_killer_3.getRow() && currentColumn==packman_killer_3.getCol()){
            mediaPlayer2.stop();
            return true ;
        }
        if(currentRow == packman_killer_4.getRow() && currentColumn==packman_killer_4.getCol()){
            mediaPlayer2.stop();
            return true ;
        }
        for (int row = 1; row < 28; row++) {
            for (int col = 1; col < 23; col++) {
                Node node = getNodeFromGridPane(MAP, col , row);
                if (node != null && node instanceof StackPane) {
                    return false ;
                    }
                }
            }
        return true ;
    }

    @FXML
    public void Exit_Map(MouseEvent event) throws IOException {
        mediaPlayer1.stop();
        mediaPlayer2.stop();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("firstpage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));

    }
    @FXML
    public void BOOSTER_CLICK(MouseEvent event) {
        if (score > 500) {
            score -= 200;
            speed = 10;
            zariib = 2 ;

            PauseTransition pause = new PauseTransition(Duration.seconds(10));
            pause.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    speed = 200;
                    zariib = 1 ;
                }
            });
            pause.play();
        }
    }
}
