package com.example.clashofclans.view;

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
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ProfileMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private Rectangle rec_topBackground;
    private Label lbl_name;
    private Label lbl_win;
    private Label lbl_lost;
    private Button rec_level;
    private HBox hb_cup;
    private HBox hb_star;
    private ScrollPane scp_map;
    private Player player;
    public ProfileMenu(Stage owner,Player player){
        this.player=player;
        setStageSetting(owner);
    }
    private void setStageSetting(Stage owner){
        stage=new Stage();
        root=new AnchorPane();
        scene=new Scene(root);

        setRec_topBackgroundSetting();
        setLbl_nameSetting();
        setRec_levelSetting();
        setHb_cupSetting();
        setLbl_winSetting();
        setLbl_lostSetting();
        setHb_starSetting();
        setScp_mapSetting();

        stage.setScene(scene);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    private void setRec_topBackgroundSetting(){
        rec_topBackground=new Rectangle();

        rec_topBackground.setWidth(800);
        rec_topBackground.setHeight(150);
        rec_topBackground.setFill(Color.rgb(70,15,150));

        root.getChildren().add(rec_topBackground);
    }
    private void setLbl_nameSetting(){
        lbl_name=new Label(player.getName());

        lbl_name.setAlignment(Pos.CENTER_LEFT);
        lbl_name.setLayoutX(15);
        lbl_name.setLayoutY(15);
        lbl_name.setFont(Font.font("Impact",35));
        lbl_name.setTextFill(Color.rgb(250,250,250));
        lbl_name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_name);
    }
    private void setRec_levelSetting(){
        rec_level=new Button();

        Label label=new Label(String.valueOf(player.getLevel()));
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",45));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        rec_level.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(70);
        rectangle.setHeight(70);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        rec_level.setShape(rectangle);

        rec_level.setBackground(Background.fill(Color.rgb(40,180,250)));
        rec_level.setPrefWidth(70);
        rec_level.setPrefHeight(70);
        rec_level.setLayoutY(50);
        rec_level.setLayoutX(120);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,200,240));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        rec_level.setEffect(dropShadow);


        root.getChildren().add(rec_level);
    }
    private void setHb_cupSetting(){
        hb_cup=new HBox();

        hb_cup.setLayoutX(200);
        hb_cup.setLayoutY(70);

        Label label=new Label(String.valueOf(player.getCup()+"  "));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setFont(Font.font("Impact",35));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hb_cup.getChildren().add(label);

        ImageView cup=new ImageView("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\cup.png");
        cup.setFitHeight(35);
        cup.setFitWidth(35);
        hb_cup.getChildren().add(cup);

        root.getChildren().add(hb_cup);
    }
    private void setLbl_winSetting(){
        lbl_win=new Label("Win : "+player.getWin());

        lbl_win.setAlignment(Pos.CENTER_LEFT);
        lbl_win.setLayoutX(600);
        lbl_win.setLayoutY(15);
        lbl_win.setFont(Font.font("Impact",30));
        lbl_win.setTextFill(Color.rgb(250,250,250));
        lbl_win.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_win);
    }
    private void setLbl_lostSetting(){
        lbl_lost=new Label("Lost : "+player.getLost());

        lbl_lost.setAlignment(Pos.CENTER_LEFT);
        lbl_lost.setLayoutX(600);
        lbl_lost.setLayoutY(50);
        lbl_lost.setFont(Font.font("Impact",30));
        lbl_lost.setTextFill(Color.rgb(250,250,250));
        lbl_lost.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_lost);
    }
    private void setHb_starSetting(){
        hb_star=new HBox();

        hb_star.setLayoutY(100);
        hb_star.setLayoutX(600);

        Label label=new Label(String.valueOf(player.getStars()+"  "));
        label.setAlignment(Pos.CENTER_LEFT);
        label.setFont(Font.font("Impact",35));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hb_star.getChildren().add(label);

        ImageView cup=new ImageView("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\star.png");
        cup.setFitHeight(50);
        cup.setFitWidth(50);
        hb_star.getChildren().add(cup);

        root.getChildren().add(hb_star);
    }
    private void setScp_mapSetting(){
        scp_map=new ScrollPane();

        scp_map.setPrefWidth(750);
        scp_map.setPrefHeight(380);
        scp_map.setContent(player.getBaseMap().copyBase());
        scp_map.setLayoutX(20);
        scp_map.setLayoutY(175);
        scp_map.setVvalue(0.4);
        scp_map.setHvalue(0.55);
        scp_map.setPannable(true);
        scp_map.setBorder(Border.stroke(Color.rgb(30,30,30)));
        scp_map.setBackground(Background.fill(Color.rgb(30,30,30)));
        scp_map.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scp_map.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        root.getChildren().add(scp_map);
    }
}
