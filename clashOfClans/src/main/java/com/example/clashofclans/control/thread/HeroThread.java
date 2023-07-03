package com.example.clashofclans.control.thread;

import com.example.clashofclans.control.hero.HeroManager;
import com.example.clashofclans.model.building.Building;
import com.example.clashofclans.model.hero.*;
import com.example.clashofclans.model.map.Map;
import javafx.animation.PathTransition;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class HeroThread extends Thread{
    private Hero hero;
    private Building target;
    private Map map;
    private double x1;
    private double y1;
    private AnchorPane root;
    public HeroThread(Hero hero, Map map,double x1,double y1){
        this.map=map;
        this.hero=hero;
        this.x1=x1;
        this.y1=y1;
    }
    private void calculateClosestBuilding(ArrayList<Building> buildings){
        int min=1000000;
        for (Building b:buildings){
            int distant=HeroManager.calculateDistance((int)b.getX(),(int)b.getY(),(int)hero.getImg_troop().getX(),(int)hero.getImg_troop().getY());
            if (distant<min){
                min=distant;
                target=b;
            }
        }
    }
    public void myWait(){
        try {
            this.wait();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void run() {
        calculateClosestBuilding(map.getBuildings());
        HeroManager.move(hero.getImg_troop(),x1,y1,target.getX(),target.getY());

        System.out.println("dhakwudhkuawd");
    }
}
