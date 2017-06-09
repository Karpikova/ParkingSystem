package com.company;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public class DataException extends Exception {
    String whatHappend;

    public DataException(String whatHappend) {
        this.whatHappend = whatHappend;
    }
}
