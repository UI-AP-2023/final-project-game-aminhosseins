package com.example.clashofclans.control.player;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.exceptions.Entry.DuplicateNameException;
import com.example.clashofclans.exceptions.Entry.InvalidPasswordException;
import com.example.clashofclans.exceptions.Entry.InvalidPlayerException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerManager {
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
