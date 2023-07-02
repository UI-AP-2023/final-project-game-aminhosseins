package com.example.clashofclans.model.player;

import com.example.clashofclans.model.hero.Hero;
import com.example.clashofclans.model.map.Map;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private String name;
    private int level;
    private int xp;
    private int maxXp;
    private int cup;
    private int win;
    private int lost;
    private int stars;
    private Map baseMap;
    private HashMap<Hero,Integer> army;
    public Player(String name,int level,int xp,int cup,int win,int lost,int stars,Map baseMap){
        this.name=name;
        this.level=level;
        this.xp=xp;
        this.cup=cup;
        this.win=win;
        this.lost=lost;
        this.stars=stars;
        this.baseMap=baseMap;
        this.army=new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getMaxXp() {
        return maxXp;
    }

    public int getCup() {
        return cup;
    }

    public int getWin() {
        return win;
    }

    public int getLost() {
        return lost;
    }

    public Map getBaseMap() {
        return baseMap;
    }

    public int getStars() {
        return stars;
    }

    public HashMap<Hero,Integer> getArmy() {
        return army;
    }
}
