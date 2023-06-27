package com.example.clashofclans.exceptions.Entry;

public class InvalidPasswordException extends InvalidEntryException{
    public InvalidPasswordException(String massage){
        super("Password format : "+"Password format is wrong");
    }
}
