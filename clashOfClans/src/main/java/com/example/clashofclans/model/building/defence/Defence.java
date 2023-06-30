package com.example.clashofclans.model.building.defence;

import com.example.clashofclans.model.building.Building;

public abstract class Defence extends Building {
    private int damage;
    private int range;
    private int attackSpeed;
    private Target target;
    public Defence(int HP,int percent,double X,double Y,double width,double height,String imgURL,int damage,int range,int attackSpeed,Target target){
        super(HP,percent,X,Y,width,height,imgURL);
        this.damage=damage;
        this.range=range;
        this.attackSpeed=attackSpeed;
        this.target=target;
    }
}
