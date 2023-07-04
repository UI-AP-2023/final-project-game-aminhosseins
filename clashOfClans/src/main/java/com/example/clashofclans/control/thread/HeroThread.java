package com.example.clashofclans.control.thread;

import com.example.clashofclans.control.hero.HeroManager;
import com.example.clashofclans.model.building.Building;
import com.example.clashofclans.model.hero.*;
import com.example.clashofclans.model.map.Map;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.ArrayList;

public class HeroThread extends Thread{
    private static ArrayList<HeroThread> allHero;

    public static ArrayList<HeroThread> getAllHero() {
        return allHero;
    }

    static {
        allHero=new ArrayList<>();
    }
    private Hero hero;
    private Building target;
    private Map map;
    private double X0;
    private double Y0;
    private int HP;
    private AnchorPane root;
    public HeroThread(Hero hero, Map map,double x1,double y1,AnchorPane root){
        this.map=map;
        this.hero=hero;
        this.X0 =x1;
        this.Y0 =y1;
        allHero.add(this);
        this.root=root;
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
    private void move(){
        while (true){
            moveDirection(hero.getImg_troop().getX(),hero.getImg_troop().getY(),target.getX(),target.getY());
            mySleep(100);
            if (target.getBuildingPhoto().getBoundsInParent().intersects(hero.getImg_troop().getBoundsInParent())&&!target.isDestroyed()){
                attack();
                calculateClosestBuilding(map.getBuildings());
            }
            if (hero.getImg_troop().getX()>750){
                System.out.println("finish");
                break;
            }
        }
    }
    private void moveDirection(double Xh,double Yh,double Xb,double Yb){
        if((Xh-Xb>0)&&(Yh-Yb>0)){
            hero.getImg_troop().setX(hero.getImg_troop().getX()-(hero.getSpeed())*iCalculate(hero.getImg_troop().getX()-target.getX()));
            hero.getImg_troop().setY(hero.getImg_troop().getY()-(hero.getSpeed())*iCalculate(hero.getImg_troop().getY()-target.getY()));
        }
        else if ((Xh-Xb<0)&&(Yh-Yb>0)){
            hero.getImg_troop().setX(hero.getImg_troop().getX()+(hero.getSpeed())*iCalculate(hero.getImg_troop().getX()-target.getX()));
            hero.getImg_troop().setY(hero.getImg_troop().getY()-(hero.getSpeed())*iCalculate(hero.getImg_troop().getY()-target.getY()));
        }
        else if ((Xh-Xb>0)&&(Yh-Yb<0)){
            hero.getImg_troop().setX(hero.getImg_troop().getX()-(hero.getSpeed())*iCalculate(hero.getImg_troop().getX()-target.getX()));
            hero.getImg_troop().setY(hero.getImg_troop().getY()+(hero.getSpeed())*iCalculate(hero.getImg_troop().getY()-target.getY()));
        }
        else if ((Xh-Xb<0)&&(Yh-Yb<0)){
            hero.getImg_troop().setX(hero.getImg_troop().getX()+(hero.getSpeed())*iCalculate(hero.getImg_troop().getX()-target.getX()));
            hero.getImg_troop().setY(hero.getImg_troop().getY()+(hero.getSpeed())*iCalculate(hero.getImg_troop().getY()-target.getY()));
        }
    }
    private double iCalculate(double X){
        return Math.abs(X)/(HeroManager.calculateDistance((int)hero.getImg_troop().getX(),(int)hero.getImg_troop().getY(),(int)target.getX(),(int)target.getY()));
    }
    private void attack(){
        while (true){
            target.setHP(target.getHP()-hero.getDMG());
            System.out.println(hero.getClass().getSimpleName()+" attack");
            mySleep(300);
            if (target.getHP()<=0){
                target.setDestroyed(true);
                root.getChildren().remove(target);
                System.out.println("building destroyed");
                X0=target.getX();
                Y0=target.getY();
                break;
            }
        }
    }
    @Override
    public void run() {
        calculateClosestBuilding(map.getBuildings());
        move();

    }
    public void myWait(){
        try {
            synchronized (this){
                wait();
            }
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public void myNotify(){
        synchronized (this){
            notify();
        }
    }
    private void mySleep(int mili){
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}
