package com.company.DAO;

import com.company.Entities.FileData;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public interface ReadDataDaoInterface {
    FileData getDataFromFile(String fileName);
}
