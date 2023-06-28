package com.example.clashofclans.control.player;

import com.example.clashofclans.control.SQL.SQLManager;
import com.example.clashofclans.exceptions.Entry.DuplicateNameException;
import com.example.clashofclans.exceptions.Entry.InvalidPasswordException;

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
}
