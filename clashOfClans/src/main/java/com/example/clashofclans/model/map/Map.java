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

    private void baseSetting(){
        base=new AnchorPane();
        img_map.setFitWidth(1280);
        img_map.setFitHeight(700);
        base.getChildren().add(img_map);

        switch (this.ID){
            case 1:
                setMapBuildings1();
                break;
            case 2:
                setMapBuildings2();
                break;
            case 3:
                setMapBuildings3();
                break;
            case 4:
                setMapBuildings4();
                break;
            default:
                break;
        }

        for (Building b:buildings){
            base.getChildren().add(b.getBuildingPhoto());
        }

    }
    private void setMapBuildings1(){
        this.buildings.add(new Kitchen(630,140));
        this.buildings.add(new GoldMine(675,175));
        this.buildings.add(new GoldMine(590,175));
        this.buildings.add(new SmallCabin(540,210));
        this.buildings.add(new SmallCabin(740,210));
        this.buildings.add(new MegaTesla(635,190));
        this.buildings.add(new Cannon(575,220));
        this.buildings.add(new Cannon(680,220));
        this.buildings.add(new SmallHut(540,255));
        this.buildings.add(new SmallHut(730,255));
        this.buildings.add(new ClanCastle(635,235));
        this.buildings.add(new ClanHouse(585,265));
        this.buildings.add(new ClanHouse(665,265));
        this.buildings.add(new WoodenHouse(500,285));
        this.buildings.add(new WoodenHouse(490,340));
        this.buildings.add(new WoodenHouse(760,285));
        this.buildings.add(new SmallCabin(770,340));
        this.buildings.add(new TownHall(630,300));
        this.buildings.add(new GoldStorage(590,345));
        this.buildings.add(new GoldStorage(680,345));
        this.buildings.add(new SlantedHouse(540,380));
        this.buildings.add(new SlantedHouse(730,380));
        this.buildings.add(new XBow(635,370));
        this.buildings.add(new ArcherTower(550,300));
        this.buildings.add(new ArcherTower(715,300));
        this.buildings.add(new ArcherTower(675,390));
        this.buildings.add(new Cannon(590,400));
        this.buildings.add(new GoldMine(640,440));
        this.buildings.add(new Barracks(560,420));
        this.buildings.add(new DarkBarracks(710,430));
    }
    private void setMapBuildings2(){
        this.buildings.add(new SmallCabin(515,215));
        this.buildings.add(new SmallHut(645,170));
        this.buildings.add(new ArcherTower(670,190));
        this.buildings.add(new GoldMine(720,200));
        this.buildings.add(new DarkBarracks(710,235));
        this.buildings.add(new WoodenHouse(770,290));
        this.buildings.add(new Cannon(530,240));
        this.buildings.add(new SlantedHouse(580,200));
        this.buildings.add(new SlantedHouse(490,265));
        this.buildings.add(new MegaTesla(570,255));
        this.buildings.add(new ClanHouse(620,215));
        this.buildings.add(new ClanHouse(510,290));
        this.buildings.add(new SmallHut(430,320));
        this.buildings.add(new ArcherTower(475,320));
        this.buildings.add(new GoldStorage(660,265));
        this.buildings.add(new TownHall(610,280));
        this.buildings.add(new Kitchen(690,300));
        this.buildings.add(new XBow(655,325));
        this.buildings.add(new GoldStorage(570,320));
        this.buildings.add(new Barracks(535,345));
        this.buildings.add(new Cannon(520,410));
        this.buildings.add(new Cannon(765,235));
        this.buildings.add(new ClanCastle(615,340));
        this.buildings.add(new WoodenHouse(660,400));
        this.buildings.add(new WoodenHouse(590,410));
        this.buildings.add(new ArcherTower(690,340));
        this.buildings.add(new GoldMine(750,340));
        this.buildings.add(new GoldMine(470,380));
        this.buildings.add(new SmallCabin(755,375));
        this.buildings.add(new SmallCabin(720,400));
    }
    private void setMapBuildings3(){
        this.buildings.add(new GoldMine(635,220));
        this.buildings.add(new SlantedHouse(580,225));
        this.buildings.add(new SlantedHouse(685,225));
        this.buildings.add(new SmallHut(515,240));
        this.buildings.add(new SmallHut(750,240));
        this.buildings.add(new MegaTesla(635,250));
        this.buildings.add(new Cannon(545,255));
        this.buildings.add(new ClanHouse(500,270));
        this.buildings.add(new ClanHouse(750,270));
        this.buildings.add(new SmallCabin(450,290));
        this.buildings.add(new SmallCabin(820,285));
        this.buildings.add(new ArcherTower(715,245));
        this.buildings.add(new GoldStorage(590,280));
        this.buildings.add(new GoldStorage(680,280));
        this.buildings.add(new ArcherTower(545,300));
        this.buildings.add(new Cannon(710,310));
        this.buildings.add(new TownHall(630,300));
        this.buildings.add(new Barracks(580,320));
        this.buildings.add(new Kitchen(510,340));
        this.buildings.add(new WoodenHouse(760,340));
        this.buildings.add(new DarkBarracks(680,330));
        this.buildings.add(new XBow(635,360));
        this.buildings.add(new GoldMine(550,370));
        this.buildings.add(new GoldMine(730,370));
        this.buildings.add(new Cannon(590,390));
        this.buildings.add(new ArcherTower(680,375));
        this.buildings.add(new ClanCastle(640,410));
        this.buildings.add(new WoodenHouse(560,420));
        this.buildings.add(new WoodenHouse(710,420));
        this.buildings.add(new SmallCabin(645,470));
    }
    private void setMapBuildings4(){
        this.buildings.add(new GoldMine(590,180));
        this.buildings.add(new DarkBarracks(675,170));
        this.buildings.add(new ClanHouse(630,200));
        this.buildings.add(new Kitchen(520,210));
        this.buildings.add(new WoodenHouse(740,220));
        this.buildings.add(new XBow(635,250));
        this.buildings.add(new ClanCastle(590,280));
        this.buildings.add(new WoodenHouse(490,280));
        this.buildings.add(new WoodenHouse(770,280));
        this.buildings.add(new SmallCabin(810,320));
        this.buildings.add(new SmallCabin(460,320));
        this.buildings.add(new Cannon(550,240));
        this.buildings.add(new ArcherTower(710,235));
        this.buildings.add(new Barracks(675,270));
        this.buildings.add(new ArcherTower(530,310));
        this.buildings.add(new Cannon(730,315));
        this.buildings.add(new TownHall(630,300));
        this.buildings.add(new GoldStorage(590,340));
        this.buildings.add(new GoldStorage(680,340));
        this.buildings.add(new SmallHut(490,360));
        this.buildings.add(new SmallHut(770,360));
        this.buildings.add(new MegaTesla(635,360));
        this.buildings.add(new ArcherTower(710,370));
        this.buildings.add(new Cannon(550,380));
        this.buildings.add(new SlantedHouse(520,400));
        this.buildings.add(new SlantedHouse(740,400));
        this.buildings.add(new ClanHouse(625,405));
        this.buildings.add(new GoldMine(580,440));
        this.buildings.add(new GoldMine(685,440));
        this.buildings.add(new SmallCabin(635,465));
    }
}
