package com.example.clashofclans.model.building.resource;

import com.example.clashofclans.model.building.Building;

public abstract class Resource extends Building {
    public Resource(int HP,int percent,double X,double Y,double dimension,String imgURL){
        super(HP,percent,X,Y,dimension,imgURL);
    }
}
