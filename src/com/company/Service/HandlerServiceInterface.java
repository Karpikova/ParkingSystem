package com.company.Service;

import com.company.DataException;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public interface HandlerServiceInterface {
    void startApp();
    void printReport();
    void carOut(String car) throws DataException;
    void carIn(String car);
}
