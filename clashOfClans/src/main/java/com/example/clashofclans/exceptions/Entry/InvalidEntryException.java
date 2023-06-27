package com.example.clashofclans.exceptions.Entry;

public class InvalidEntryException extends Exception{
    public InvalidEntryException(String massage){
        super("Entry : "+massage);
    }
}
