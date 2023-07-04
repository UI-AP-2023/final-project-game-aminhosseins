package com.example.clashofclans;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.control.hero.HeroManager;
import com.example.clashofclans.model.map.Map;
import com.example.clashofclans.view.ChoosingMapMenu;
import com.example.clashofclans.view.PlayerBaseMenu;
import com.example.clashofclans.view.StartMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override 
    public void start(Stage stage) throws IOException, SQLException {
        //StartMenu startMenu=new StartMenu();
        PlayerBaseMenu playerBaseMenu=new PlayerBaseMenu("amin");
    }

    public static void main(String[] args) {
        launch();
    }
}