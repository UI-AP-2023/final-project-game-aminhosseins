package com.example.clashofclans.view;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.control.player.PlayerManager;
import com.example.clashofclans.exceptions.Entry.DuplicateNameException;
import com.example.clashofclans.exceptions.Entry.InvalidEntryException;
import com.example.clashofclans.exceptions.Entry.InvalidPasswordException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.SQLException;

public class SignUpMenu {
    private Stage stage;
    private Scene scene;
    private AnchorPane root;
    private Label lbl_title;
    private Label lbl_name;
    private Label lbl_password;
    private TextField txt_name;
    private PasswordField txt_password;
    private Button btn_signUp;
    public SignUpMenu(Stage owner){
        setStageSetting(owner);
    }
    private void setStageSetting(Stage owner){
        stage=new Stage();
        root=new AnchorPane();
        root.setBackground(Background.fill(Color.rgb(240,240,240)));
        scene=new Scene(root);

        setLbl_titleSetting();
        setLbl_nameSetting();
        setTxt_nameSetting();
        setTxt_passwordSetting();
        setLbl_passwordSetting();
        setBtn_signUpSetting(owner);

        stage.setWidth(600);
        stage.setHeight(400);
        stage.setScene(scene);
        stage.initOwner(owner);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();
    }
    private void setLbl_titleSetting(){
        lbl_title=new Label("SIGN UP MENU");

        lbl_title.setFont(Font.font("Impact",55));
        lbl_title.setTextFill(Color.rgb(240,240,240));
        lbl_title.setBackground(Background.fill(Color.rgb(30,120,250)));
        lbl_title.setPrefWidth(600);
        lbl_title.setPrefHeight(80);
        lbl_title.setAlignment(Pos.CENTER);

        root.getChildren().add(lbl_title);
    }
    private void setLbl_nameSetting(){
        lbl_name=new Label("Name : ");

        lbl_name.setFont(Font.font("Impact",30));
        lbl_name.setTextFill(Color.rgb(10,10,10));
        lbl_name.setAlignment(Pos.CENTER);
        lbl_name.setPrefHeight(40);
        lbl_name.setPrefWidth(100);
        lbl_name.setLayoutX(90);
        lbl_name.setLayoutY(125);
        lbl_name.setTextFill(Color.gray(0.25));

        root.getChildren().add(lbl_name);
    }
    private void setTxt_nameSetting(){
        txt_name=new TextField();

        txt_name.setPrefWidth(220);
        txt_name.setPrefHeight(40);
        txt_name.setLayoutX(190);
        txt_name.setLayoutY(130);
        txt_name.setBorder(Border.stroke(Color.rgb(240,240,240)));
        txt_name.setBackground(Background.fill(Color.rgb(230,230,230)));
        txt_name.setFont(Font.font("Impact",18));

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(180);
        rectangle.setHeight(40);
        rectangle.setArcWidth(18);
        rectangle.setArcHeight(18);
        txt_name.setShape(rectangle);

        InnerShadow shadow=new InnerShadow();
        shadow.setRadius(7);
        shadow.setColor(Color.gray(0.2));
        txt_name.setEffect(shadow);

        root.getChildren().add(txt_name);
    }
    private void setTxt_passwordSetting(){

        txt_password=new PasswordField();

        txt_password.setPrefWidth(220);
        txt_password.setPrefHeight(40);
        txt_password.setLayoutX(190);
        txt_password.setLayoutY(210);
        txt_password.setBorder(Border.stroke(Color.rgb(240,240,240)));
        txt_password.setBackground(Background.fill(Color.rgb(230,230,230)));
        txt_password.setFont(Font.font("Impact",18));

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(180);
        rectangle.setHeight(40);
        rectangle.setArcWidth(18);
        rectangle.setArcHeight(18);
        txt_password.setShape(rectangle);

        InnerShadow shadow=new InnerShadow();
        shadow.setRadius(7);
        shadow.setColor(Color.gray(0.2));
        txt_password.setEffect(shadow);

        root.getChildren().add(txt_password);
    }
    private void setLbl_passwordSetting(){
        lbl_password=new Label("Password : ");

        lbl_password.setFont(Font.font("Impact",20));
        lbl_password.setTextFill(Color.rgb(10,10,10));
        lbl_password.setAlignment(Pos.CENTER);
        lbl_password.setPrefHeight(40);
        lbl_password.setPrefWidth(100);
        lbl_password.setLayoutX(83);
        lbl_password.setLayoutY(207);
        lbl_password.setTextFill(Color.gray(0.25));

        root.getChildren().add(lbl_password);
    }
    private void setBtn_signUpSetting(Stage owner){
        btn_signUp=new Button();

        Label label=new Label("Sign up");
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font("Impact",25));
        label.setTextFill(Color.rgb(250,250,250));
        label.setStyle("-fx-effect: dropshadow( one-pass-box , black , 4 , 0.0 , 1 , 0 )");
        btn_signUp.setGraphic(label);

        Rectangle rectangle=new Rectangle();
        rectangle.setWidth(150);
        rectangle.setHeight(40);
        rectangle.setArcHeight(20);
        rectangle.setArcWidth(20);
        btn_signUp.setShape(rectangle);

        btn_signUp.setBackground(Background.fill(Color.rgb(30,120,250)));
        btn_signUp.setPrefWidth(150);
        btn_signUp.setPrefHeight(40);
        btn_signUp.setLayoutY(285);
        btn_signUp.setLayoutX(225);

        DropShadow dropShadow =new DropShadow();
        dropShadow.setRadius(3);
        dropShadow.setColor(Color.gray(0.5));
        btn_signUp.setEffect(dropShadow);

        btn_signUp.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            btn_signUp.setScaleX(1.02);
            btn_signUp.setScaleY(1.02);
            dropShadow.setRadius(6);
        });
        btn_signUp.addEventHandler(MouseEvent.MOUSE_EXITED,mouseEvent -> {
            btn_signUp.setScaleX(1);
            btn_signUp.setScaleY(1);
            dropShadow.setRadius(3);
        });
        btn_signUp.addEventHandler(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            try {
                PlayerManager.signUpOperation(txt_name.getText(),txt_password.getText());
                ChoosingMapMenu choosingMapMenu=new ChoosingMapMenu(txt_name.getText());
                stage.close();
                owner.close();
            } catch (SQLException e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("SQL");
                alert.show();
            } catch (InvalidEntryException e) {
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.setTitle("Error");
                alert.setHeaderText("Entry");
                alert.show();
            }
        });


        root.getChildren().add(btn_signUp);
    }

}
