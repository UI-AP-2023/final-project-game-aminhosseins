package com.example.clashofclans.model.hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Hero {
    private int HP;
    private int DMG;
    private int speed;
    private int range;
    private int space;
    private AttackTarget target;
    private ImageView img_troop;
    private ImageView img_icon;
    public Hero(int HP,int DMG,int speed,int range,int space,AttackTarget target,String troopURL,String iconURL){
        this.HP=HP;
        this.DMG=DMG;
        this.speed=speed;
        this.range=range;
        this.space=space;
        this.target=target;
        img_troop=new ImageView(new Image(troopURL));
        img_icon=new ImageView(new Image(iconURL));
    }

    public int getHP() {
        return HP;
    }

    public int getDMG() {
        return DMG;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRange() {
        return range;
    }

    public int getSpace() {
        return space;
    }

    public AttackTarget getTarget() {
        return target;
    }

    public ImageView getImg_troop() {
        return img_troop;
    }

    public ImageView getImg_icon() {
        return img_icon;
    }
}
