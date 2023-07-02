package com.example.clashofclans.view;

import com.example.clashofclans.model.player.Player;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Scanner;

public class TrainArmyMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private HBox hb_trainQueue;
    private Player player;
    public TrainArmyMenu(Stage owner, Player player){
        this.player=player;
        setStageSetting(owner);
    }
    private void setStageSetting(Stage owner){
        stage=new Stage();
        root=new AnchorPane();
        scene=new Scene(root);



        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
}
