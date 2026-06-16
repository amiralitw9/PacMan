package com.example.packman;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;


public class packman_killer {
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
    public packman_killer(GridPane Map , String address){
        this.Map =Map ;
        this.address = address ;
        Image gifImage = new Image(address);
        this.image_packman_killer = gifImage;
        gifImageView= new ImageView(image_packman_killer);
        gifImageView.setFitWidth(30);
        gifImageView.setFitHeight(30);
        Random random = new Random();
        int randomNumber = 10 + random.nextInt(6);
        this.row =  randomNumber ;
        randomNumber = 9 + random.nextInt(5);
        this.col=randomNumber;
    }
    public String address;
    public int row , col ;
    public GridPane Map ;
    public Image image_packman_killer;
    public ImageView gifImageView ;
    public String direction = "up" ;
    public boolean exit = false ;


    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void move(){
        boolean is_input = false ;
        check_exit();
        Node node = getNodeFromGridPane(Map, col, row - 1);
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) && direction=="up"){
            is_input = true ;
            change_way(Map);
        }
        node = getNodeFromGridPane(Map, col, row + 1);
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue"))&& direction=="down" ){
            is_input  =true ;
            change_way(Map);
        }
        node = getNodeFromGridPane(Map, col-1, row );
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) && direction=="left" ){
            is_input  =true ;
            change_way(Map);
        }
        node = getNodeFromGridPane(Map, col+1, row );
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) && direction=="right"){
            is_input  =true ;
            change_way(Map);
        }
        if(is_input==false) {
            switch (direction){
                case "up":
                    if(row>1){
                        row-=1;
                    }
                    if(row==1){
                        change_way(Map);
                    }
                    break;
                case "down":
                    if(is_input==true && row==9 && col>9 && col<13){
                        direction = "right";
                    }
                    else {
                        row+=1 ;
                    }
                    break;
                case "left":
                    if(col>1){
                        col-=1;
                    }
                    if(col==1){
                        change_way(Map);
                    }
                    break;
                case "right":
                    col+=1;
                    break;
            }
        }
    }
    public void  change_way(GridPane Map ){

        ArrayList<String> newway = new ArrayList<>();
        Node node = getNodeFromGridPane(Map, col, row - 1);
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) ){
        }
        else if(row>1) {
            newway.add("up");
        }
        node = getNodeFromGridPane(Map, col, row + 1);
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) ){
        }
        else{
        newway.add("down");
        }
        node = getNodeFromGridPane(Map, col-1, row );
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) ){
        }
        else if(col>1) {
            newway.add("left");
        }
        node = getNodeFromGridPane(Map, col+1, row );
        if(node instanceof Rectangle && ((Rectangle) node).getFill().equals(Paint.valueOf("blue")) ){
        }
        else {
            newway.add("right");
        }
        int random_num = get_random_for_change_way(newway.size());
        switch (newway.get(random_num)){
            case "up":
                row-=1;
                direction = "up";
                break;
            case "down":
                row+=1;
                direction = "down";
                break;
            case "left":
                col-=1;
                direction = "left";
                break;
            case "right":
                col+=1;
                direction = "right";
                break;


        }
    }

    public ImageView getGifImageView(){
        return this.gifImageView;
    }
    public Image getImage_packman_killer(){
        return this.image_packman_killer;
    }
    public int get_random_for_change_way(int num){
        Random random = new Random();
        int randomNumber = random.nextInt(num) + 0;
        return randomNumber ;
    }
    public void check_exit(){
        if(row<10){
            exit = true ;
        }
    }
}
