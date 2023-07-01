package com.example.clashofclans.view;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.model.map.Map;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class ChoosingMapMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private AnchorPane insidePane;
    private Pagination pg_mapSelector;
    private Button btn_setMap;
    private String playerName;
    public ChoosingMapMenu(String playerName){
        this.playerName=playerName;
        setStageSetting();
    }
    private void setStageSetting(){
        stage=new Stage();
        root=new AnchorPane();
        root.setBackground(Background.fill(Color.rgb(40,40,40)));
        scene=new Scene(root);

        setInsidePaneSetting();

        stage.setMaximized(true);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    private void setInsidePaneSetting(){
        insidePane=new AnchorPane();
        insidePane.setPrefWidth(1000);
        insidePane.setPrefHeight(600);
        insidePane.setLayoutX(140);
        insidePane.setLayoutY(30);
        insidePane.setBackground(Background.fill(Color.rgb(30,30,30)));

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(1000);
        rectangle.setHeight(600);
        rectangle.setArcHeight(90);
        rectangle.setArcWidth(90);
        insidePane.setShape(rectangle);

        DropShadow shadow=new DropShadow();
        shadow.setRadius(40);
        shadow.setColor(Color.gray(0));
        insidePane.setEffect(shadow);

        setPg_mapSelectorSetting();
        setBtn_setMapSetting();

        root.getChildren().add(insidePane);
    }
    private void setPg_mapSelectorSetting(){
        pg_mapSelector=new Pagination();
        pg_mapSelector.setPrefWidth(900);
        pg_mapSelector.setPrefHeight(520);
        pg_mapSelector.setLayoutX(50);
        pg_mapSelector.setLayoutY(30);
        pg_mapSelector.setPageCount(4);
        pg_mapSelector.getStylesheets().add("Pagination.css");
        pg_mapSelector.setPageFactory(integer -> {
            ScrollPane scrollPane=new ScrollPane(Map.getAllMaps().get(integer).getBase());
            scrollPane.setPrefWidth(768);
            scrollPane.setPrefHeight(420);
            scrollPane.setVvalue(0.4);
            scrollPane.setHvalue(0.55);
            scrollPane.setPannable(true);
            scrollPane.setBorder(Border.stroke(Color.rgb(30,30,30)));
            scrollPane.setBackground(Background.fill(Color.rgb(30,30,30)));
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            return scrollPane;
        });

        insidePane.getChildren().add(pg_mapSelector);
    }
    private void setBtn_setMapSetting(){
        btn_setMap=new Button();

        Label label=new Label("Choose");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_setMap.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(40);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_setMap.setShape(rectangle);

        btn_setMap.setBackground(Background.fill(Color.rgb(25,200,35)));
        btn_setMap.setPrefWidth(140);
        btn_setMap.setPrefHeight(40);
        btn_setMap.setLayoutY(540);
        btn_setMap.setLayoutX(430);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(180,255,80));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_setMap.setEffect(dropShadow);

        btn_setMap.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_setMap.setScaleX(1.02);
            btn_setMap.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_setMap.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_setMap.setScaleX(1);
            btn_setMap.setScaleY(1);
            dropShadow.setRadius(5);
        });

        btn_setMap.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                SQLManager.updateMapID(pg_mapSelector.getCurrentPageIndex()+1,playerName);
                PlayerBaseMenu playerBaseMenu=new PlayerBaseMenu(playerName);
                stage.close();
            }catch (SQLException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            }
        });

        insidePane.getChildren().add(btn_setMap);
    }

}
