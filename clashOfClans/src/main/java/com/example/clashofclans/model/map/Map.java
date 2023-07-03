package com.example.clashofclans.model.map;

import com.example.clashofclans.model.building.Building;
import com.example.clashofclans.model.building.defence.ArcherTower;
import com.example.clashofclans.model.building.defence.Cannon;
import com.example.clashofclans.model.building.defence.MegaTesla;
import com.example.clashofclans.model.building.defence.XBow;
import com.example.clashofclans.model.building.normal.*;
import com.example.clashofclans.model.building.resource.ClanCastle;
import com.example.clashofclans.model.building.resource.GoldMine;
import com.example.clashofclans.model.building.resource.GoldStorage;
import com.example.clashofclans.model.building.resource.TownHall;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Map {
    private static int allMapCount =1;
    private static ArrayList<Map> allMaps;
    static {
        allMaps=new ArrayList<>();
        allMaps.add(new Map());
        allMaps.add(new Map());
        allMaps.add(new Map());
        allMaps.add(new Map());
        allMaps.add(new Map());
    }

    public static ArrayList<Map> getAllMaps() {
        return allMaps;
    }

    private int ID;
    private final ImageView img_map;
    private AnchorPane base;
    private ArrayList<Building> buildings;
    private Map(){
        this.ID= allMapCount++;
        this.img_map=new ImageView(new Image("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\map.jpg"));
        buildings=new ArrayList<>();
        baseSetting();
    }
    public int getID() {
        return ID;
    }

    public AnchorPane getBase() {
        return base;
    }
    public AnchorPane copyBase(){
        AnchorPane pane=new AnchorPane();
        ImageView imageView=new ImageView(new Image("C:\\Users\\j-tech.ir\\Desktop\\uni\\game\\final-project-game-aminhosseins\\clashOfClans\\src\\main\\resources\\map.jpg"));
        imageView.setFitWidth(1280);
        imageView.setFitHeight(700);
        pane.getChildren().add(imageView);
        ArrayList<Building> buildingArrayList=null;
        switch (this.ID){
            case 1:
                buildingArrayList=setMapBuildings1();
                break;
            case 2:
                buildingArrayList=setMapBuildings2();
                break;
            case 3:
                buildingArrayList=setMapBuildings3();
                break;
            case 4:
                buildingArrayList=setMapBuildings4();
                break;
            default:
                break;
        }
        for (Building b:buildingArrayList){
            pane.getChildren().add(b.getBuildingPhoto());
        }
        return pane;
    }


    private void baseSetting(){
        base=new AnchorPane();
        img_map.setFitWidth(1280);
        img_map.setFitHeight(700);
        base.getChildren().add(img_map);

        switch (this.ID){
            case 1:
                this.buildings=setMapBuildings1();
                break;
            case 2:
                this.buildings=setMapBuildings2();
                break;
            case 3:
                this.buildings=setMapBuildings3();
                break;
            case 4:
                this.buildings=setMapBuildings4();
                break;
            default:
                break;
        }

        for (Building b:buildings){
            base.getChildren().add(b.getBuildingPhoto());
        }

    }
    private ArrayList<Building> setMapBuildings1(){
        ArrayList<Building > buildings=new ArrayList<>();
        buildings.add(new Kitchen(630,140));
        buildings.add(new GoldMine(675,175));
        buildings.add(new GoldMine(590,175));
        buildings.add(new SmallCabin(540,210));
        buildings.add(new SmallCabin(740,210));
        buildings.add(new MegaTesla(635,190));
        buildings.add(new Cannon(575,220));
        buildings.add(new Cannon(680,220));
        buildings.add(new SmallHut(540,255));
        buildings.add(new SmallHut(730,255));
        buildings.add(new ClanCastle(635,235));
        buildings.add(new ClanHouse(585,265));
        buildings.add(new ClanHouse(665,265));
        buildings.add(new WoodenHouse(500,285));
        buildings.add(new WoodenHouse(490,340));
        buildings.add(new WoodenHouse(760,285));
        buildings.add(new SmallCabin(770,340));
        buildings.add(new TownHall(630,300));
        buildings.add(new GoldStorage(590,345));
        buildings.add(new GoldStorage(680,345));
        buildings.add(new SlantedHouse(540,380));
        buildings.add(new SlantedHouse(730,380));
        buildings.add(new XBow(635,370));
        buildings.add(new ArcherTower(550,300));
        buildings.add(new ArcherTower(715,300));
        buildings.add(new ArcherTower(675,390));
        buildings.add(new Cannon(590,400));
        buildings.add(new GoldMine(640,440));
        buildings.add(new Barracks(560,420));
        buildings.add(new DarkBarracks(710,430));
        return buildings;
    }
    private ArrayList<Building> setMapBuildings2(){
        ArrayList<Building> buildings=new ArrayList<>();
        buildings.add(new SmallCabin(515,215));
        buildings.add(new SmallHut(645,170));
        buildings.add(new ArcherTower(670,190));
        buildings.add(new GoldMine(720,200));
        buildings.add(new DarkBarracks(710,235));
        buildings.add(new WoodenHouse(770,290));
        buildings.add(new Cannon(530,240));
        buildings.add(new SlantedHouse(580,200));
        buildings.add(new SlantedHouse(490,265));
        buildings.add(new MegaTesla(570,255));
        buildings.add(new ClanHouse(620,215));
        buildings.add(new ClanHouse(510,290));
        buildings.add(new SmallHut(430,320));
        buildings.add(new ArcherTower(475,320));
        buildings.add(new GoldStorage(660,265));
        buildings.add(new TownHall(610,280));
        buildings.add(new Kitchen(690,300));
        buildings.add(new XBow(655,325));
        buildings.add(new GoldStorage(570,320));
        buildings.add(new Barracks(535,345));
        buildings.add(new Cannon(520,410));
        buildings.add(new Cannon(765,235));
        buildings.add(new ClanCastle(615,340));
        buildings.add(new WoodenHouse(660,400));
        buildings.add(new WoodenHouse(590,410));
        buildings.add(new ArcherTower(690,340));
        buildings.add(new GoldMine(750,340));
        buildings.add(new GoldMine(470,380));
        buildings.add(new SmallCabin(755,375));
        buildings.add(new SmallCabin(720,400));
        return buildings;
    }
    private ArrayList<Building> setMapBuildings3(){
        ArrayList<Building> buildings=new ArrayList<>();
        buildings.add(new GoldMine(635,220));
        buildings.add(new SlantedHouse(580,225));
        buildings.add(new SlantedHouse(685,225));
        buildings.add(new SmallHut(515,240));
        buildings.add(new SmallHut(750,240));
        buildings.add(new MegaTesla(635,250));
        buildings.add(new Cannon(545,255));
        buildings.add(new ClanHouse(500,270));
        buildings.add(new ClanHouse(750,270));
        buildings.add(new SmallCabin(450,290));
        buildings.add(new SmallCabin(820,285));
        buildings.add(new ArcherTower(715,245));
        buildings.add(new GoldStorage(590,280));
        buildings.add(new GoldStorage(680,280));
        buildings.add(new ArcherTower(545,300));
        buildings.add(new Cannon(710,310));
        buildings.add(new TownHall(630,300));
        buildings.add(new Barracks(580,320));
        buildings.add(new Kitchen(510,340));
        buildings.add(new WoodenHouse(760,340));
        buildings.add(new DarkBarracks(680,330));
        buildings.add(new XBow(635,360));
        buildings.add(new GoldMine(550,370));
        buildings.add(new GoldMine(730,370));
        buildings.add(new Cannon(590,390));
        buildings.add(new ArcherTower(680,375));
        buildings.add(new ClanCastle(640,410));
        buildings.add(new WoodenHouse(560,420));
        buildings.add(new WoodenHouse(710,420));
        buildings.add(new SmallCabin(645,470));
        return buildings;
    }
    private ArrayList<Building> setMapBuildings4(){
        ArrayList<Building> buildings=new ArrayList<>();
        buildings.add(new GoldMine(590,180));
        buildings.add(new DarkBarracks(675,170));
        buildings.add(new ClanHouse(630,200));
        buildings.add(new Kitchen(520,210));
        buildings.add(new WoodenHouse(740,220));
        buildings.add(new XBow(635,250));
        buildings.add(new ClanCastle(590,280));
        buildings.add(new WoodenHouse(490,280));
        buildings.add(new WoodenHouse(770,280));
        buildings.add(new SmallCabin(810,320));
        buildings.add(new SmallCabin(460,320));
        buildings.add(new Cannon(550,240));
        buildings.add(new ArcherTower(710,235));
        buildings.add(new Barracks(675,270));
        buildings.add(new ArcherTower(530,310));
        buildings.add(new Cannon(730,315));
        buildings.add(new TownHall(630,300));
        buildings.add(new GoldStorage(590,340));
        buildings.add(new GoldStorage(680,340));
        buildings.add(new SmallHut(490,360));
        buildings.add(new SmallHut(770,360));
        buildings.add(new MegaTesla(635,360));
        buildings.add(new ArcherTower(710,370));
        buildings.add(new Cannon(550,380));
        buildings.add(new SlantedHouse(520,400));
        buildings.add(new SlantedHouse(740,400));
        buildings.add(new ClanHouse(625,405));
        buildings.add(new GoldMine(580,440));
        buildings.add(new GoldMine(685,440));
        buildings.add(new SmallCabin(635,465));
        return buildings;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
