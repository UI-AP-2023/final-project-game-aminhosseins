package com.example.clashofclans.model.building.resource;

import com.example.clashofclans.model.building.Building;

public abstract class Resource extends Building {
    public Resource(int HP,int percent,double X,double Y,double width,double height,String imgURL){
        super(HP,percent,X,Y,width,height,imgURL);
    }
}
