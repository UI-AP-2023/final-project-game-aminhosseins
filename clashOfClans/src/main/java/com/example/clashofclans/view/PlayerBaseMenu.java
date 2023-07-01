package com.example.clashofclans.view;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PlayerBaseMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    public PlayerBaseMenu(){
        setStageSetting();
    }
    private void setStageSetting(){
        stage=new Stage();
        root=new AnchorPane();
        scene=new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }
}
