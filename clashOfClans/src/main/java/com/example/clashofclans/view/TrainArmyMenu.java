package com.example.clashofclans.view;

import com.example.clashofclans.control.hero.HeroManager;
import com.example.clashofclans.model.building.Building;
import com.example.clashofclans.model.hero.*;
import com.example.clashofclans.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Map;
import java.util.Scanner;

public class TrainArmyMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private Button btn_barbarian;
    private Button btn_archer;
    private Button btn_giant;
    private Button btn_goblin;
    private Button btn_minion;
    private Button btn_balloon;
    private Button btn_golem;
    private Button btn_pekka;
    private Button btn_save;
    private Button btn_delete;
    private TilePane tp_troops;
    private HBox hb_trainQueue;
    private Player player;
    public TrainArmyMenu(Stage owner, Player player){
        this.player=player;
        setStageSetting(owner);
        armyChange();
    }
    private void setStageSetting(Stage owner){
        stage=new Stage();
        root=new AnchorPane();
        scene=new Scene(root);

        setHb_trainQueueSetting();
        setTp_troopsSetting();
        setBtn_saveSetting();
        setBtn_deleteSetting();

        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    private void setHb_trainQueueSetting(){
        hb_trainQueue=new HBox();

        hb_trainQueue.setAlignment(Pos.CENTER_RIGHT);
        hb_trainQueue.setSpacing(5);
        hb_trainQueue.setPrefWidth(785);
        hb_trainQueue.setPrefHeight(120);
        hb_trainQueue.setBackground(Background.fill(Color.rgb(230,230,230)));

        InnerShadow shadow=new InnerShadow();
        shadow.setColor(Color.rgb(210,210,210));
        shadow.setRadius(10);
        hb_trainQueue.setEffect(shadow);

        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setLayoutY(25);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        scrollPane.setContent(hb_trainQueue);

        root.getChildren().add(scrollPane);
    }
    private void setTp_troopsSetting(){
        tp_troops=new TilePane();

        tp_troops.setLayoutY(250);
        tp_troops.setPrefWidth(785);
        tp_troops.setHgap(30);
        tp_troops.setVgap(40);
        tp_troops.setAlignment(Pos.CENTER);
        tp_troops.setBackground(Background.fill(Color.rgb(230,230,230)));

        setBtn_barbarianSetting();
        setBtn_archerSetting();
        setBtn_giantSetting();
        setBtn_goblinSetting();
        setBtn_minionSetting();
        setBtn_balloonSetting();
        setBtn_golemSetting();
        setBtn_pekkaSetting();

        InnerShadow shadow=new InnerShadow();
        shadow.setColor(Color.rgb(210,210,210));
        shadow.setRadius(10);
        tp_troops.setEffect(shadow);

        root.getChildren().add(tp_troops);
    }
    private void setBtn_barbarianSetting(){
        btn_barbarian=new Button();

        ImageView imageView=new Barbarian().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_barbarian.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_barbarian.setShape(rectangle);

        btn_barbarian.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_barbarian.setPrefWidth(120);
        btn_barbarian.setPrefHeight(120);
        btn_barbarian.setTooltip(new Tooltip(new Barbarian().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_barbarian.setEffect(dropShadow);

        btn_barbarian.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_barbarian.setScaleX(1.02);
            btn_barbarian.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_barbarian.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_barbarian.setScaleX(1);
            btn_barbarian.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_barbarian.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addBarbarian(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_barbarian);
    }
    private void setBtn_archerSetting(){
        btn_archer=new Button();

        ImageView imageView=new Archer().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_archer.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_archer.setShape(rectangle);

        btn_archer.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_archer.setPrefWidth(120);
        btn_archer.setPrefHeight(120);
        btn_archer.setTooltip(new Tooltip(new Archer().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_archer.setEffect(dropShadow);

        btn_archer.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_archer.setScaleX(1.02);
            btn_archer.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_archer.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_archer.setScaleX(1);
            btn_archer.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_archer.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addArcher(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_archer);
    }
    private void setBtn_giantSetting(){
        btn_giant=new Button();

        ImageView imageView=new Giant().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_giant.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_giant.setShape(rectangle);

        btn_giant.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_giant.setPrefWidth(120);
        btn_giant.setPrefHeight(120);
        btn_giant.setTooltip(new Tooltip(new Giant().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_giant.setEffect(dropShadow);

        btn_giant.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_giant.setScaleX(1.02);
            btn_giant.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_giant.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_giant.setScaleX(1);
            btn_giant.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_giant.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addGiant(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_giant);
    }
    private void setBtn_goblinSetting(){
        btn_goblin=new Button();

        ImageView imageView=new Goblin().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_goblin.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_goblin.setShape(rectangle);

        btn_goblin.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_goblin.setPrefWidth(120);
        btn_goblin.setPrefHeight(120);
        btn_goblin.setTooltip(new Tooltip(new Goblin().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_goblin.setEffect(dropShadow);

        btn_goblin.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_goblin.setScaleX(1.02);
            btn_goblin.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_goblin.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_goblin.setScaleX(1);
            btn_goblin.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_goblin.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addGoblin(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_goblin);
    }
    private void setBtn_minionSetting(){
        btn_minion=new Button();

        ImageView imageView=new Minion().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_minion.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_minion.setShape(rectangle);

        btn_minion.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_minion.setPrefWidth(120);
        btn_minion.setPrefHeight(120);
        btn_minion.setTooltip(new Tooltip(new Minion().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_minion.setEffect(dropShadow);

        btn_minion.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_minion.setScaleX(1.02);
            btn_minion.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_minion.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_minion.setScaleX(1);
            btn_minion.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_minion.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addMinion(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_minion);
    }
    private void setBtn_balloonSetting(){
        btn_balloon=new Button();

        ImageView imageView=new Balloon().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_balloon.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_balloon.setShape(rectangle);

        btn_balloon.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_balloon.setPrefWidth(120);
        btn_balloon.setPrefHeight(120);
        btn_balloon.setTooltip(new Tooltip(new Balloon().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_balloon.setEffect(dropShadow);

        btn_balloon.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_balloon.setScaleX(1.02);
            btn_balloon.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_balloon.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_balloon.setScaleX(1);
            btn_balloon.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_balloon.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addBalloon(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_balloon);
    }
    private void setBtn_golemSetting(){
        btn_golem=new Button();

        ImageView imageView=new Golem().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_golem.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_golem.setShape(rectangle);

        btn_golem.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_golem.setPrefWidth(120);
        btn_golem.setPrefHeight(120);
        btn_golem.setTooltip(new Tooltip(new Golem().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_golem.setEffect(dropShadow);

        btn_golem.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_golem.setScaleX(1.02);
            btn_golem.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_golem.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_golem.setScaleX(1);
            btn_golem.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_golem.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addGolem(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_golem);
    }
    private void setBtn_pekkaSetting(){
        btn_pekka=new Button();

        ImageView imageView=new PEKKA().getImg_icon();
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        btn_pekka.setGraphic(imageView);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(120);
        rectangle.setHeight(120);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_pekka.setShape(rectangle);

        btn_pekka.setBackground(Background.fill(Color.rgb(40,120,220)));
        btn_pekka.setPrefWidth(120);
        btn_pekka.setPrefHeight(120);
        btn_pekka.setTooltip(new Tooltip(new PEKKA().toString()));

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,120,180));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_pekka.setEffect(dropShadow);

        btn_pekka.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_pekka.setScaleX(1.02);
            btn_pekka.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_pekka.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_pekka.setScaleX(1);
            btn_pekka.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_pekka.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            HeroManager.addPEKKA(player.getArmy());
            armyChange();
        });

        tp_troops.getChildren().add(btn_pekka);
    }
    private void setBtn_deleteSetting(){
        btn_delete=new Button();

        Label label=new Label("Delete");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_delete.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(60);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_delete.setShape(rectangle);

        btn_delete.setBackground(Background.fill(Color.rgb(200,15,15)));
        btn_delete.setPrefWidth(140);
        btn_delete.setPrefHeight(60);
        btn_delete.setLayoutY(165);
        btn_delete.setLayoutX(210);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,60,15));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_delete.setEffect(dropShadow);

        btn_delete.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_delete.setScaleX(1.02);
            btn_delete.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_delete.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_delete.setScaleX(1);
            btn_delete.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_delete.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            player.getArmy().clear();
            armyChange();
        });

        root.getChildren().add(btn_delete);
    }
    private void setBtn_saveSetting(){
        btn_save=new Button();

        Label label=new Label("Save");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_save.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(60);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_save.setShape(rectangle);

        btn_save.setBackground(Background.fill(Color.rgb(25,200,35)));
        btn_save.setPrefWidth(140);
        btn_save.setPrefHeight(60);
        btn_save.setLayoutY(165);
        btn_save.setLayoutX(440);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(180,255,80));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_save.setEffect(dropShadow);

        btn_save.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_save.setScaleX(1.02);
            btn_save.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_save.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_save.setScaleX(1);
            btn_save.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_save.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            stage.close();
        });

        root.getChildren().add(btn_save);
    }
    private void armyChange(){
        hb_trainQueue.getChildren().clear();
        for (Map.Entry<Hero,Integer> entry:player.getArmy().entrySet()){
            StackPane stackPane=new StackPane();
            Button btn=new Button();

            ImageView imageView=entry.getKey().getImg_icon();
            imageView.setFitHeight(90);
            imageView.setFitWidth(90);
            btn.setGraphic(imageView);

            Rectangle rectangle=new Rectangle();
            rectangle.setWidth(90);
            rectangle.setHeight(90);
            rectangle.setArcHeight(30);
            rectangle.setArcWidth(30);
            btn.setShape(rectangle);

            btn.setBackground(Background.fill(Color.rgb(40,120,220)));
            btn.setPrefWidth(90);
            btn.setPrefHeight(90);

            InnerShadow innerShadow=new InnerShadow();
            innerShadow.setRadius(20);
            innerShadow.setColor(Color.rgb(40,120,180));
            DropShadow dropShadow =new DropShadow();
            dropShadow.setRadius(5);
            dropShadow.setColor(Color.gray(0.5));
            dropShadow.setInput(innerShadow);
            btn.setEffect(dropShadow);

            Label label=new Label("X"+entry.getValue());

            label.setAlignment(Pos.CENTER);
            label.setFont(Font.font("Impact",30));
            label.setTextFill(Color.rgb(250,250,250));
            label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
            label.setLayoutX(0);
            label.setLayoutY(0);

            stackPane.getChildren().add(btn);
            stackPane.getChildren().add(label);
            hb_trainQueue.getChildren().add(stackPane);
        }
    }

}
