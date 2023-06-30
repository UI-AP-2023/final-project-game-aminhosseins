package com.example.clashofclans.model.building.normal;

import com.example.clashofclans.model.building.Building;

public abstract class Normal extends Building {
    public Normal(int HP,int percent,double X,double Y,double width,double height,String imgURL){
        super(HP,percent,X,Y,width,height,imgURL);
    }
}
