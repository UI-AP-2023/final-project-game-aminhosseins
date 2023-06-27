package com.example.clashofclans.model.player;

import com.example.clashofclans.model.map.Map;

public class Player {
    private String name;
    private String password;
    private int level;
    private int win;
    private int lost;
    private Map baseMap;
    public Player(String name,String password,int level,int win,int lost,Map baseMap){
        this.name=name;
        this.password=password;
        this.level=level;
        this.win=win;
        this.lost=lost;
        this.baseMap=baseMap;
    }
}
