package com.example.clashofclans.view;

import com.example.clashofclans.control.player.PlayerManager;
import com.example.clashofclans.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class PlayerBaseMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private Button btn_attack;
    private Button btn_trainArmy;
    private Button btn_changeMap;
    private Button btn_leaderBoard;
    private Button btn_profile;
    private ProgressBar prg_levelXp;
    private Label lbl_name;
    private Player player;
    private HBox hb_cup;
    public PlayerBaseMenu(String playerName) throws SQLException {
        player= PlayerManager.readyMainPlayer(playerName);
        setStageSetting();
    }
    private void setStageSetting(){
        stage=new Stage();
        root=new AnchorPane();
        root.getChildren().add(player.getBaseMap().getBase());
        scene=new Scene(root);

        setBtn_attackSetting();
        setBtn_trainArmySetting();
        setBtn_changeMapSetting();
        setBtn_leaderBoardSetting();
        setBtn_profileSetting();
        setPrg_levelXpSetting();
        setLbl_nameSetting();
        setHb_cupSetting();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }
    private void setBtn_attackSetting(){
        btn_attack=new Button();

        Label label=new Label("Attack");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",40));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_attack.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(160);
        rectangle.setHeight(160);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_attack.setShape(rectangle);

        btn_attack.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_attack.setPrefWidth(160);
        btn_attack.setPrefHeight(160);
        btn_attack.setLayoutY(510);
        btn_attack.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_attack.setEffect(dropShadow);

        btn_attack.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_attack.setScaleX(1.02);
            btn_attack.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_attack.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_attack.setScaleX(1);
            btn_attack.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_attack.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                FindEnemyMenu findEnemyMenu=new FindEnemyMenu(player);
                stage.close();
            }catch (SQLException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            }
        });

        root.getChildren().add(btn_attack);
    }
    private void setBtn_trainArmySetting(){
        btn_trainArmy=new Button();

        Label label=new Label("Train\nArmy");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",40));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_trainArmy.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(160);
        rectangle.setHeight(160);
        rectangle.setArcHeight(30);
        rectangle.setArcWidth(30);
        btn_trainArmy.setShape(rectangle);

        btn_trainArmy.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_trainArmy.setPrefWidth(160);
        btn_trainArmy.setPrefHeight(160);
        btn_trainArmy.setLayoutY(510);
        btn_trainArmy.setLayoutX(1090);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_trainArmy.setEffect(dropShadow);

        btn_trainArmy.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_trainArmy.setScaleX(1.02);
            btn_trainArmy.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_trainArmy.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_trainArmy.setScaleX(1);
            btn_trainArmy.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_trainArmy.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            TrainArmyMenu trainArmyMenu=new TrainArmyMenu(stage,player);
        });

        root.getChildren().add(btn_trainArmy);
    }
    private void setBtn_changeMapSetting(){
        btn_changeMap=new Button();

        Label label=new Label("Change\n    Map");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",17));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_changeMap.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_changeMap.setShape(rectangle);

        btn_changeMap.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_changeMap.setPrefWidth(70);
        btn_changeMap.setPrefHeight(70);
        btn_changeMap.setLayoutY(420);
        btn_changeMap.setLayoutX(1180);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(15);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_changeMap.setEffect(dropShadow);

        btn_changeMap.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_changeMap.setScaleX(1.02);
            btn_changeMap.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_changeMap.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_changeMap.setScaleX(1);
            btn_changeMap.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_changeMap.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            ChoosingMapMenu choosingMapMenu=new ChoosingMapMenu(player.getName());
            stage.close();
        });

        root.getChildren().add(btn_changeMap);
    }
    private void setBtn_leaderBoardSetting(){
        btn_leaderBoard=new Button();

        Label label=new Label("Leader\n Board");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",18));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_leaderBoard.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_leaderBoard.setShape(rectangle);

        btn_leaderBoard.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_leaderBoard.setPrefWidth(70);
        btn_leaderBoard.setPrefHeight(70);
        btn_leaderBoard.setLayoutY(420);
        btn_leaderBoard.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_leaderBoard.setEffect(dropShadow);

        btn_leaderBoard.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_leaderBoard.setScaleX(1.02);
            btn_leaderBoard.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_leaderBoard.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_leaderBoard.setScaleX(1);
            btn_leaderBoard.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_leaderBoard.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                LeaderBoardMenu leaderBoardMenu=new LeaderBoardMenu(stage);
            }catch (SQLException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            }
        });

        root.getChildren().add(btn_leaderBoard);
    }
    private void setBtn_profileSetting(){
        btn_profile=new Button();

        Label label=new Label(String.valueOf(player.getLevel()));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",45));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_profile.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_profile.setShape(rectangle);

        btn_profile.setBackground(Background.fill(Color.rgb(40,180,250)));
        btn_profile.setPrefWidth(70);
        btn_profile.setPrefHeight(70);
        btn_profile.setLayoutY(30);
        btn_profile.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,200,240));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_profile.setEffect(dropShadow);

        btn_profile.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_profile.setScaleX(1.02);
            btn_profile.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_profile.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_profile.setScaleX(1);
            btn_profile.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_profile.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            ProfileMenu profileMenu=new ProfileMenu(stage,player);
        });

        root.getChildren().add(btn_profile);
    }
    private void setPrg_levelXpSetting(){
        prg_levelXp=new ProgressBar();

        prg_levelXp.setPrefSize(140,25);
        prg_levelXp.setLayoutX(100);
        prg_levelXp.setLayoutY(50);
        prg_levelXp.setProgress((double) player.getXp()/player.getMaxXp());

        root.getChildren().add(prg_levelXp);
    }
    private void setLbl_nameSetting(){
        lbl_name=new Label(player.getName());

        lbl_name.setAlignment(Pos.CENTER_LEFT);
        lbl_name.setLayoutX(110);
        lbl_name.setLayoutY(25);
        lbl_name.setFont(Font.font("Impact",25));
        lbl_name.setTextFill(Color.rgb(250,250,250));
        lbl_name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_name);
    }
    private void setHb_cupSetting(){
        hb_cup=new HBox();

        hb_cup.setLayoutX(110);
        hb_cup.setLayoutY(80);

        Label label=new Label(String.valueOf(player.getCup()));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setFont(Font.font("Impact",25));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hb_cup.getChildren().add(label);

        ImageView cup=new ImageView("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\cup.png");
        cup.setFitHeight(25);
        cup.setFitWidth(25);
        hb_cup.getChildren().add(cup);

        root.getChildren().add(hb_cup);
    }
}
