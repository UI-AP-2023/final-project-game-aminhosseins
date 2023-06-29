package com.example.clashofclans.model.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Building{
    private int HP;
    private int percent;
    private double X;
    private double Y;
    private double dimension;
    private ImageView buildingPhoto;
    public Building(int HP,int percent,double X,double Y,double dimension,String imgURL){
        this.HP=HP;
        this.percent=percent;
        this.X=X;
        this.Y=Y;
        this.dimension=dimension;
        this.buildingPhoto=new ImageView(new Image(imgURL));
    }
}
