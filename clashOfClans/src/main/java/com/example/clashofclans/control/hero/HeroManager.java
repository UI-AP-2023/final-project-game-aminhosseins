package com.example.clashofclans.control.hero;

import com.example.clashofclans.control.thread.HeroThread;
import com.example.clashofclans.model.hero.*;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Map;

public class HeroManager {
    public static void addBarbarian(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Barbarian){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Barbarian(),1);
    }
    public static void addArcher(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Archer){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Archer(),1);
    }
    public static void addGiant(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Giant){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Giant(),1);
    }
    public static void addGoblin(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Goblin){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Goblin(),1);
    }
    public static void addMinion(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Minion){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Minion(),1);
    }
    public static void addBalloon(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Balloon){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Balloon(),1);
    }
    public static void addGolem(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof Golem){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new Golem(),1);
    }
    public static void addPEKKA(HashMap<Hero,Integer> army){
        boolean isThere=false;
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if(entry.getKey() instanceof PEKKA){
                army.put(entry.getKey(), entry.getValue()+1);
                isThere=true;
            }
        }
        if (!isThere)army.put(new PEKKA(),1);
    }
    public static void removeBarbarian(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Barbarian){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeArcher(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Archer){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeGiant(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Giant){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeGoblin(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Goblin){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeMinion(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Minion){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeBalloon(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Balloon){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removeGolem(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof Golem){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static void removePEKKA(HashMap<Hero,Integer> army){
        for (Map.Entry<Hero,Integer> entry:army.entrySet()){
            if (entry.getKey() instanceof PEKKA){
                army.put(entry.getKey(),entry.getValue()-1);
            }
        }
    }
    public static int calculateDistance(int X1,int Y1,int X2,int Y2){
        return (int) Math.sqrt(((X1-X2)*(X1-X2))+((Y1-Y2)*(Y1-Y2)));
    }
    public static Hero setHero(String name){
        switch (name){
            case "barbarian":
                return new Barbarian();
            case "archer":
                return new Archer();
            case "giant":
                return new Giant();
            case "goblin":
                return new Goblin();
            case "minion":
                return new Minion();
            case "balloon":
                return new Balloon();
            case "golem":
                return new Golem();
            case "pekka":
                return new PEKKA();
            default:
                break;
        }
        return null;
    }
    public static void move( ImageView heroImg, double X1, double Y1, double X2, double Y2){
        Path path = new Path();
        MoveTo moveTo = new MoveTo(X1,Y1);
        LineTo lineTo = new LineTo(X2, Y2);
        path.getElements().add(moveTo);
        path.getElements().add(lineTo);
        PathTransition transition = new PathTransition();
        transition.setNode(heroImg);
        transition.setDuration(Duration.millis(8000));
        transition.setPath(path);
        transition.play();
        transition.setOnFinished(actionEvent -> {

        });
    }
    public static void myWait(){

    }
}
