package com.example.clashofclans.exceptions.Entry;

public class InvalidPlayerException extends InvalidEntryException{
    public InvalidPlayerException(String massage){
        super("Invalid player : "+massage);
    }
}
