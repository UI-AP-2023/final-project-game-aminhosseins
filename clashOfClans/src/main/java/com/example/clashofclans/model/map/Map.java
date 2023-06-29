package com.example.clashofclans.model.map;

import com.example.clashofclans.model.building.Building;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Map {
    //need work...
    private static int allMap=1;
    private int ID;
    private final ImageView img_map;
    private AnchorPane base;
    private ArrayList<Building> buildings;
    public Map(){
        this.ID=allMap++;
        this.img_map=new ImageView(new Image("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\map.jpg"));
        baseSetting();
    }
    public int getID() {
        return ID;
    }

    public AnchorPane getBase() {
        return base;
    }

    private void baseSetting(){
        base=new AnchorPane();
        img_map.setFitWidth(1280);
        img_map.setFitHeight(700);
        base.getChildren().add(img_map);
    }
}
