package com.example.clashofclans.model.building;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Building{
    private int HP;
    private int percent;
    private double X;
    private double Y;
    private double width;
    private double height;
    private ImageView buildingPhoto;
    public Building(int HP,int percent,double X,double Y,double width,double height,String imgURL){
        this.HP=HP;
        this.percent=percent;
        this.X=X;
        this.Y=Y;
        this.width=width;
        this.height=height;
        this.buildingPhoto=new ImageView(new Image(imgURL));
        buildingPhoto.setX(X);
        buildingPhoto.setY(Y);
        buildingPhoto.setFitHeight(height);
        buildingPhoto.setFitWidth(width);
    }

    public ImageView getBuildingPhoto() {
        return buildingPhoto;
    }

    public int getHP() {
        return HP;
    }

    public int getPercent() {
        return percent;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
