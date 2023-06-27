package com.example.clashofclans.exceptions.Entry;

public class DuplicateNameException extends InvalidEntryException{
    public DuplicateNameException(String massage){
        super("Duplicate name : "+massage);
    }
}
