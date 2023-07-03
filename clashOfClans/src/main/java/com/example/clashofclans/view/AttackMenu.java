package com.example.clashofclans.view;

import com.example.clashofclans.control.hero.HeroManager;
import com.example.clashofclans.control.thread.HeroThread;
import com.example.clashofclans.model.hero.*;
import com.example.clashofclans.model.player.Player;
import javafx.animation.PathTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Map;

public class AttackMenu {
    private VBox vb_army;
    private Button selectedButton;
    private FindEnemyMenu findEnemyMenu;
    private Player player;
    public AttackMenu(FindEnemyMenu findEnemyMenu,Player player){
        this.player=player;
        this.findEnemyMenu=findEnemyMenu;
        setAttackSetting();
    }
    private void setAttackSetting(){
        findEnemyMenu.getRoot().getChildren().remove(findEnemyMenu.getBtn_next());
        findEnemyMenu.getRoot().getChildren().remove(findEnemyMenu.getBtn_start());

        Label label=new Label("End Match");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",23));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        findEnemyMenu.getBtn_exit().setGraphic(label);
        setVb_armySetting();

        findEnemyMenu.getRoot().addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                changeTroop();
                Hero hero=HeroManager.setHero(selectedButton.getId());
                ImageView heroImg=hero.getImg_troop();
                heroImg.setX(mouseEvent.getX());
                heroImg.setY(mouseEvent.getY());
                findEnemyMenu.getRoot().getChildren().add(heroImg);
                HeroThread heroThread=new HeroThread(hero,findEnemyMenu.getEnemy().getBaseMap(),mouseEvent.getX(),mouseEvent.getY());
                heroThread.start();
                updateArmy();
            }catch (NullPointerException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Match");
                alert.setContentText("Please select a uint");
                alert.show();
            }
        });
    }
    private void setVb_armySetting(){
        vb_army=new VBox();

        vb_army.setAlignment(Pos.TOP_CENTER);
        vb_army.setSpacing(5);
        vb_army.setPrefSize(100,700);
        vb_army.setBackground(Background.fill(Color.rgb(0,0,0,0.5)));
        vb_army.setLayoutX(1180);
        findEnemyMenu.getRoot().getChildren().remove(findEnemyMenu.getVb_army());

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
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                if(selectedButton!=null){
                    btn.setBorder(Border.stroke(Color.WHITE));
                    this.selectedButton.setBorder(Border.EMPTY);
                    this.selectedButton=btn;
                }
                else {
                    selectedButton=btn;
                    selectedButton.setBorder(Border.stroke(Color.WHITE));
                }
            });

            setBtnID(btn,entry.getKey());

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

        findEnemyMenu.getRoot().getChildren().add(vb_army);
    }
    private void setBtnID(Button button,Hero hero){
        if (hero instanceof Barbarian){
            button.setId("barbarian");
        }
        else if(hero instanceof Archer){
            button.setId("archer");
        }
        else if(hero instanceof Giant){
            button.setId("giant");
        }
        else if(hero instanceof Goblin){
            button.setId("goblin");
        }
        else if(hero instanceof Minion){
            button.setId("minion");
        }
        else if(hero instanceof Balloon){
            button.setId("balloon");
        }
        else if(hero instanceof Golem){
            button.setId("golem");
        }
        else if(hero instanceof PEKKA){
            button.setId("pekka");
        }
    }
    private void updateArmy(){

        vb_army.getChildren().clear();

        for (Map.Entry<Hero,Integer> entry:player.getArmy().entrySet()){
            if (entry.getValue()>0){
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
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                    if(selectedButton!=null){
                        btn.setBorder(Border.stroke(Color.WHITE));
                        this.selectedButton.setBorder(Border.EMPTY);
                        this.selectedButton=btn;
                    }
                    else {
                        selectedButton=btn;
                        selectedButton.setBorder(Border.stroke(Color.WHITE));
                    }
                });

                setBtnID(btn,entry.getKey());

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
            else selectedButton=null;
        }
    }
    private void changeTroop(){
        switch (selectedButton.getId()){
            case "barbarian":
                HeroManager.removeBarbarian(player.getArmy());
                break;
            case "archer":
                HeroManager.removeArcher(player.getArmy());
                break;
            case "giant":
                HeroManager.removeGiant(player.getArmy());
                break;
            case "goblin":
                HeroManager.removeGoblin(player.getArmy());
                break;
            case "minion":
                HeroManager.removeMinion(player.getArmy());
                break;
            case "balloon":
                HeroManager.removeBalloon(player.getArmy());
                break;
            case "golem":
                HeroManager.removeGolem(player.getArmy());
                break;
            case "pekka":
                HeroManager.removePEKKA(player.getArmy());
                break;
            default:
                break;
        }
    }
    public void move(ImageView heroImg,double X,double Y){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(X,Y);
        LineTo lineTo = new LineTo(100, 100);
        path.getElements().add(moveTo);
        path.getElements().add(lineTo);
        PathTransition transition = new PathTransition();
        transition.setNode(heroImg);
        transition.setDuration(Duration.millis(8000));
        transition.setPath(path);
        transition.play();
    }
}
