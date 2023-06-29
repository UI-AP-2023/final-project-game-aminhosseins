package com.example.clashofclans.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChoosingMapMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    public ChoosingMapMenu(){
        setStageSetting();
    }
    private void setStageSetting(){
        stage=new Stage();
        root=new AnchorPane();
        root.setBackground(Background.fill(Color.rgb(240,240,240)));
        scene=new Scene(root);
//        ImageView imageView=new ImageView(new Image("C:\\Users\\j-tech.ir\\Desktop\\uni\\picture\\Map_Classic_Scenery.jpg"));
//        imageView.setFitHeight(700);
//        imageView.setFitWidth(1280);
//        root.getChildren().add(imageView);

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
