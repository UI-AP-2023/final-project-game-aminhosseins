package com.example.clashofclans.view;

import com.example.clashofclans.control.player.PlayerManager;
import com.example.clashofclans.model.hero.Hero;
import com.example.clashofclans.model.player.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import java.util.Map;

public class FindEnemyMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private AnchorPane enemyBase;
    private Button btn_next;
    private Button btn_exit;
    private Button btn_start;
    private Button btn_level;
    private Label lbl_name;
    private Label lbl_cupPlus;
    private Label lbl_cupMines;
    private HBox hb_cup;
    private VBox vb_army;
    private Player player;
    private Player enemy;
    public FindEnemyMenu(Player player) throws SQLException {
        this.player=player;
        PlayerManager.readyAttack(player.getName());
        this.enemy=PlayerManager.readyEnemy();
        this.enemyBase=enemy.getBaseMap().copyBase();
        setStageSetting();
    }
    private void setStageSetting(){
        stage=new Stage();
        root=new AnchorPane();
        root.getChildren().add(enemyBase);
        scene=new Scene(root);

        setBtn_levelSetting();
        setLbl_nameSetting();
        setHb_cupSetting();
        setBtn_exitSetting();
        setBtn_nextSetting();
        setBtn_startSetting();
        setLbl_cupPlusSetting();
        setLbl_cupMinesSetting();
        setVb_armySetting();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.show();
    }
    private void setBtn_levelSetting(){
        btn_level=new Button();

        Label lbl_level=new Label(String.valueOf(player.getLevel()));
        lbl_level.setAlignment(Pos.CENTER);
        lbl_level.setFont(Font.font("Impact",32));
        lbl_level.setTextFill(Color.rgb(250,250,250));
        lbl_level.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_level.setGraphic(lbl_level);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(50);
        rectangle.setHeight(50);
        rectangle.setArcHeight(15);
        rectangle.setArcWidth(15);
        btn_level.setShape(rectangle);

        btn_level.setBackground(Background.fill(Color.rgb(40,180,250)));
        btn_level.setPrefWidth(50);
        btn_level.setPrefHeight(50);
        btn_level.setLayoutY(25);
        btn_level.setLayoutX(25);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(40,200,240));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_level.setEffect(dropShadow);

        root.getChildren().add(btn_level);
    }
    private void setLbl_nameSetting(){
        lbl_name=new Label(enemy.getName());

        lbl_name.setAlignment(Pos.CENTER_LEFT);
        lbl_name.setLayoutX(85);
        lbl_name.setLayoutY(20);
        lbl_name.setFont(Font.font("Impact",22));
        lbl_name.setTextFill(Color.rgb(250,250,250));
        lbl_name.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_name);
    }
    private void setHb_cupSetting(){
        hb_cup=new HBox();

        hb_cup.setLayoutX(85);
        hb_cup.setLayoutY(50);

        Label lbl_cup=new Label(String.valueOf(enemy.getCup()));
        lbl_cup.setAlignment(Pos.CENTER_LEFT);
        lbl_cup.setFont(Font.font("Impact",25));
        lbl_cup.setTextFill(Color.rgb(250,250,250));
        lbl_cup.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        hb_cup.getChildren().add(lbl_cup);

        ImageView cup=new ImageView("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\cup.png");
        cup.setFitHeight(25);
        cup.setFitWidth(25);
        hb_cup.getChildren().add(cup);

        root.getChildren().add(hb_cup);
    }
    private void setBtn_exitSetting(){
        btn_exit=new Button();

        Label label=new Label("Exit");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_exit.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(60);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_exit.setShape(rectangle);

        btn_exit.setBackground(Background.fill(Color.rgb(200,15,15)));
        btn_exit.setPrefWidth(140);
        btn_exit.setPrefHeight(60);
        btn_exit.setLayoutY(610);
        btn_exit.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,60,15));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_exit.setEffect(dropShadow);

        btn_exit.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_exit.setScaleX(1.02);
            btn_exit.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_exit.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_exit.setScaleX(1);
            btn_exit.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_exit.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                PlayerBaseMenu playerBaseMenu=new PlayerBaseMenu(player.getName());
                stage.close();
            }catch (SQLException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            }
        });

        root.getChildren().add(btn_exit);
    }
    private void setBtn_nextSetting(){
        btn_next=new Button();

        Label label=new Label("Next");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_next.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(60);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_next.setShape(rectangle);

        btn_next.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_next.setPrefWidth(140);
        btn_next.setPrefHeight(60);
        btn_next.setLayoutY(520);
        btn_next.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_next.setEffect(dropShadow);

        btn_next.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_next.setScaleX(1.02);
            btn_next.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_next.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_next.setScaleX(1);
            btn_next.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_next.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                FindEnemyMenu findEnemyMenu=new FindEnemyMenu(player);
                stage.close();
            } catch (SQLException e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            }
        });

        root.getChildren().add(btn_next);
    }
    private void setBtn_startSetting(){
        btn_start =new Button();

        Label label=new Label("Start");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",30));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_start.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(140);
        rectangle.setHeight(60);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        btn_start.setShape(rectangle);

        btn_start.setBackground(Background.fill(Color.rgb(220,120,25)));
        btn_start.setPrefWidth(140);
        btn_start.setPrefHeight(60);
        btn_start.setLayoutY(430);
        btn_start.setLayoutX(30);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(20);
        innerShadow.setColor(Color.rgb(250,180,25));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0));
        dropShadow.setInput(innerShadow);
        btn_start.setEffect(dropShadow);

        btn_start.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_start.setScaleX(1.02);
            btn_start.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_start.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_start.setScaleX(1);
            btn_start.setScaleY(1);
            dropShadow.setRadius(5);
        });

        root.getChildren().add(btn_start);
    }
    private void setLbl_cupPlusSetting(){
        lbl_cupPlus=new Label("Win "+PlayerManager.cupPlusCalculate());

        lbl_cupPlus.setAlignment(Pos.CENTER_LEFT);
        lbl_cupPlus.setLayoutX(25);
        lbl_cupPlus.setLayoutY(100);
        lbl_cupPlus.setFont(Font.font("Impact",22));
        lbl_cupPlus.setTextFill(Color.rgb(250,250,250));
        lbl_cupPlus.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");

        root.getChildren().add(lbl_cupPlus);
    }
    private void setLbl_cupMinesSetting(){
        lbl_cupMines=new Label("Lost "+PlayerManager.cupMinesCalculate());

        lbl_cupMines.setAlignment(Pos.CENTER_LEFT);
        lbl_cupMines.setLayoutX(25);
        lbl_cupMines.setLayoutY(130);
        lbl_cupMines.setFont(Font.font("Impact",22));
        lbl_cupMines.setTextFill(Color.rgb(250,250,250));
        lbl_cupMines.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 );-fx-text-fill: rgb(250,100,100)");

        root.getChildren().add(lbl_cupMines);
    }
    private void setVb_armySetting(){
        vb_army=new VBox();

        vb_army.setAlignment(Pos.TOP_CENTER);
        vb_army.setSpacing(5);
        vb_army.setPrefSize(100,700);
        vb_army.setBackground(Background.fill(Color.rgb(0,0,0,0.5)));
        vb_army.setLayoutX(1180);

        for (Map.Entry<Hero,Integer> entry:player.getArmy().entrySet()){
            AnchorPane stackPane=new AnchorPane();
            Button btn=new Button();

            ImageView imageView=entry.getKey().getImg_icon();
            imageView.setFitHeight(70);
            imageView.setFitWidth(70);
            btn.setGraphic(imageView);

            Rectangle rectangle=new Rectangle();
            rectangle.setWidth(70);
            rectangle.setHeight(70);
            rectangle.setArcHeight(24);
            rectangle.setArcWidth(24);
            btn.setShape(rectangle);

            btn.setBackground(Background.fill(Color.rgb(40,120,220)));
            btn.setPrefWidth(70);
            btn.setPrefHeight(70);

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
            vb_army.getChildren().add(stackPane);
        }

        root.getChildren().add(vb_army);
    }
}
