package com.example.clashofclans.view;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class StartMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane firstRoot;
    private AnchorPane secondRoot;
    private Label lbl_developerName;
    private Button btn_signUp;
    private Button btn_login;

    public StartMenu() {
        setStageSetting();
    }

    private void show(){
        stage.show();

        FadeTransition transition=new FadeTransition();
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.setDuration(Duration.seconds(2));
        transition.setNode(lbl_developerName);
        transition.play();
        transition.setOnFinished(actionEvent -> {
            scene.setRoot(secondRoot);
        });
    }
    private void setStageSetting() {
        stage=new Stage();

        setFirstRootSetting();
        setSecondRootSetting();

        stage.setScene(scene);
        stage.setMaximized(true);
        stage.setResizable(false);
        show();
    }
    private void setFirstRootSetting(){
        firstRoot=new AnchorPane();
        scene =new Scene(firstRoot);

        setLbl_developerNameSetting();

        firstRoot.setBackground(Background.fill(Color.rgb(0,0,0)));
    }
    private void setSecondRootSetting(){
        secondRoot=new AnchorPane();
        ImageView loadingScreen=new ImageView(new Image("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\loadingScreen.jpg"));
        loadingScreen.setFitWidth(1280);
        loadingScreen.setFitHeight(700);
        secondRoot.getChildren().add(loadingScreen);
        setBtn_signUpSetting();
        setBtn_loginSetting();
    }
    private void setLbl_developerNameSetting(){
        lbl_developerName=new Label("AminAm");

        lbl_developerName.setFont(Font.font("Impact",60));
        lbl_developerName.setBackground(Background.EMPTY);
        lbl_developerName.setPrefHeight(80);
        lbl_developerName.setPrefWidth(300);
        lbl_developerName.setLayoutY(320);
        lbl_developerName.setLayoutX(490);
        lbl_developerName.setAlignment(Pos.CENTER);
        lbl_developerName.setTextFill(Color.rgb(240,240,240));

        firstRoot.getChildren().add(lbl_developerName);
    }
    private void setBtn_signUpSetting(){
        btn_signUp=new Button();

        Label label=new Label("Sign up");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",40));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_signUp.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(300);
        rectangle.setHeight(80);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_signUp.setShape(rectangle);

        btn_signUp.setBackground(Background.fill(Color.rgb(245,150,25)));
        btn_signUp.setPrefWidth(300);
        btn_signUp.setPrefHeight(80);
        btn_signUp.setLayoutY(280);
        btn_signUp.setLayoutX(490);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(5);
        innerShadow.setColor(Color.gray(0.9));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_signUp.setEffect(dropShadow);

        btn_signUp.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_signUp.setScaleX(1.02);
            btn_signUp.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_signUp.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_signUp.setScaleX(1);
            btn_signUp.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_signUp.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            SignUpMenu signUpMenu=new SignUpMenu(stage);
        });

        secondRoot.getChildren().add(btn_signUp);
    }
    private void setBtn_loginSetting(){
        btn_login=new Button();

        Label label=new Label("Log in");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",40));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_login.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(300);
        rectangle.setHeight(80);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_login.setShape(rectangle);

        btn_login.setBackground(Background.fill(Color.rgb(245,150,25)));
        btn_login.setPrefWidth(300);
        btn_login.setPrefHeight(80);
        btn_login.setLayoutY(400);
        btn_login.setLayoutX(490);

        InnerShadow innerShadow=new InnerShadow();
        innerShadow.setRadius(5);
        innerShadow.setColor(Color.gray(0.9));
        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(5);
        dropShadow.setColor(Color.gray(0.5));
        dropShadow.setInput(innerShadow);
        btn_login.setEffect(dropShadow);

        btn_login.addEventHandler(MouseEvent.MOUSE_ENTERED,mouseEvent -> {
            btn_login.setScaleX(1.02);
            btn_login.setScaleY(1.02);
            dropShadow.setRadius(8);
        });
        btn_login.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_login.setScaleX(1);
            btn_login.setScaleY(1);
            dropShadow.setRadius(5);
        });
        btn_login.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            LogInMenu logInMenu=new LogInMenu(stage);
        });

        secondRoot.getChildren().add(btn_login);
    }
}
