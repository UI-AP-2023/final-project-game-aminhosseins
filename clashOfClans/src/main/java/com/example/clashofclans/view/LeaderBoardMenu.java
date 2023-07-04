package com.example.clashofclans.view;

import com.example.clashofclans.control.player.PlayerManager;
import com.example.clashofclans.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class LeaderBoardMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private ScrollPane scp_players;
    private Label lbl_title;
    private ArrayList<Player> players;
    public LeaderBoardMenu(Stage owner) throws SQLException {
        this.players= PlayerManager.readyLeaderBoard();
        Collections.sort(this.players);
        setStageSetting(owner);
    }
    private void setStageSetting(Stage owner){
        stage=new Stage();
        root=new AnchorPane();
        scene=new Scene(root);

        setLbl_titleSetting();
        setScp_playersSetting();

        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    private void setLbl_titleSetting(){

        lbl_title=new Label("Leader Board");

        lbl_title.setAlignment(Pos.CENTER_LEFT);
        lbl_title.setLayoutX(0);
        lbl_title.setLayoutY(0);
        lbl_title.setFont(Font.font("Impact",60));
        lbl_title.setTextFill(Color.rgb(250,250,250));
        lbl_title.setPrefWidth(800);
        lbl_title.setPrefHeight(100);
        lbl_title.setAlignment(Pos.CENTER);
        lbl_title.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        lbl_title.setBackground(Background.fill(Color.rgb(70,15,150)));

        root.getChildren().add(lbl_title);
    }
    private void setScp_playersSetting(){
        scp_players=new ScrollPane();

        scp_players.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scp_players.setPrefWidth(785);
        scp_players.setPrefHeight(450);
        scp_players.setLayoutY(100);
//        scp_players.setBackground(Background.fill(Color.rgb(240,240,240)));

        VBox vBox=new VBox();
        vBox.setBackground(Background.fill(Color.rgb(245,245,245)));
        vBox.setPrefWidth(785);
        vBox.setSpacing(10);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(700);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        vBox.setShape(rectangle);
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        vBox.setEffect(dropShadow);
        int i=1;
        for (Player p:players){
            vBox.getChildren().add(setHbPlayer(p,i++));
        }
        scp_players.setContent(vBox);

        root.getChildren().add(scp_players);
    }
    private AnchorPane setHbPlayer(Player player,int i){
        AnchorPane hBox=new AnchorPane();
        hBox.setLayoutX(5);
        hBox.setPrefWidth(700);
        hBox.setPrefHeight(70);
        hBox.setBackground(Background.fill(Color.rgb(230,230,230)));

        hBox.getChildren().add(setBtn_level(player));
        hBox.getChildren().add(setLbl_name(player));
        hBox.getChildren().add(setHb_cup(player));
        Label lbl_rank=new Label(String.valueOf(i));

        lbl_rank.setAlignment(Pos.CENTER);
        lbl_rank.setLayoutX(740);
        lbl_rank.setLayoutY(13);
        lbl_rank.setFont(Font.font("Impact",33));
        lbl_rank.setTextFill(Color.rgb(250,250,250));
        lbl_rank.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hBox.getChildren().add(lbl_rank);
        hBox.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            ProfileMenu profileMenu=new ProfileMenu(stage,player);
        });

        return hBox;
    }
    private Button setBtn_level(Player player){
        Button btn_level=new Button();

        Label label=new Label(String.valueOf(player.getLevel()));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",35));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_level.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_level.setShape(rectangle);

        btn_level.setBackground(Background.fill(Color.rgb(40,180,250)));
        btn_level.setPrefWidth(50);
        btn_level.setPrefHeight(50);
        btn_level.setLayoutY(10);
        btn_level.setLayoutX(12);


        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,200,240));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_level.setEffect(dropShadow);

        return btn_level;
    }
    private Label setLbl_name(Player player){
        Label lbl_name=new Label(player.getName());

        lbl_name.setAlignment(Pos.CENTER);
        lbl_name.setLayoutX(90);
        lbl_name.setLayoutY(13);
        lbl_name.setFont(Font.font("Impact",33));
        lbl_name.setTextFill(Color.rgb(250,250,250));
        lbl_name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        return lbl_name;
    }
    private HBox setHb_cup(Player player){
        HBox hb_cup=new HBox();

        hb_cup.setLayoutX(650);
        hb_cup.setLayoutY(13);

        Label label=new Label(String.valueOf(player.getCup()));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setFont(Font.font("Impact",33));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hb_cup.getChildren().add(label);

        ImageView cup=new ImageView("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\cup.png");
        cup.setFitHeight(33);
        cup.setFitWidth(33);
        hb_cup.getChildren().add(cup);
        return hb_cup;
    }

}
