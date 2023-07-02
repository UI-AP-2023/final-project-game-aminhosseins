package com.example.clashofclans.control.player;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.exceptions.Entry.DuplicateNameException;
import com.example.clashofclans.exceptions.Entry.InvalidPasswordException;
import com.example.clashofclans.exceptions.Entry.InvalidPlayerException;
import com.example.clashofclans.model.map.Map;
import com.example.clashofclans.model.player.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerManager {
    private static ArrayList<Player> enemies;
    static {
        enemies=new ArrayList<>();
    }
    public static void signUpOperation(String name,String password) throws SQLException, DuplicateNameException, InvalidPasswordException {
        isNameDuplicate(name);
        passwordFormatChecker(password);
        SQLManager.setNewPlayer(name,password);
    }
    public static void loginOperation(String name ,String password) throws InvalidPlayerException, SQLException, InvalidPasswordException {
        isPlayerExist(name);
        passwordFormatChecker(password);
        passwordMatching(password,name);
    }
    public static Player readyMainPlayer(String name) throws SQLException {
        ResultSet resultSet=SQLManager.getPlayerInfo(name);
        Player player=null;
        while (resultSet.next()){
            player=new Player(name,resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getInt(6),Map.getAllMaps().get(resultSet.getInt(7)-1));
        }
        return player;
    }
    public static void readyAttack(String playerName) throws SQLException {
        ResultSet resultSet=SQLManager.getAllPlayersAttackInfo();
        while (resultSet.next()){
            if (!playerName.equals(resultSet.getString(1))){
                enemies.add(new Player(resultSet.getString(1),resultSet.getInt(2),-1,resultSet.getInt(4),-1,-1,-1,Map.getAllMaps().get(resultSet.getInt(3)-1)));
            }
        }
    }
    public static Player readyEnemy(){
        Random random=new Random();
        return enemies.get(random.nextInt(enemies.size()));
    }
    public static int cupPlusCalculate(){
        Random random=new Random();
        return random.nextInt(26,34);
    }
    public static int cupMinesCalculate(){
        Random random=new Random();
        return random.nextInt(-20,-15);
    }
    private static void isNameDuplicate(String name) throws SQLException, DuplicateNameException {
        ArrayList<String> names= SQLManager.getNames();
        for (String s:names){
            if (s.equals(name))throw new DuplicateNameException("This name is already in use");
        }
    }
    private static void passwordFormatChecker(String password) throws InvalidPasswordException {
        Pattern passwordPattern=Pattern.compile("\\S{8,}");
        Matcher matcher=passwordPattern.matcher(password);
        if(!matcher.find()) throw new InvalidPasswordException("Password should be at least 8 characters");
    }
    private static void isPlayerExist(String name) throws SQLException, InvalidPlayerException {
        ArrayList<String> names= SQLManager.getNames();
        boolean isThere=false;
        for (String s:names){
            if (name.equals(s))
                isThere=true;
        }
        if (!isThere) throw new InvalidPlayerException("Player with this name does not exist");
    }
    private static void passwordMatching(String password,String name) throws SQLException, InvalidPasswordException {
        if(!password.equals(SQLManager.getPlayerPassword(name)))throw new InvalidPasswordException("Your password is wrong");
    }
}
