package com.example.clashofclans.control.hero;

import com.example.clashofclans.model.hero.*;

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
}
