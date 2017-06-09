package com.company.Service;

import com.company.ApplicationService;
import com.company.DAO.ReadDataDAO;
import com.company.DAO.ReadDataDaoInterface;
import com.company.Entities.FileData;

import java.util.Map;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public class LoadService implements LoadServiceInterface{

    ReadDataDaoInterface readDataDAO = new ReadDataDAO();

    @Override
    public void loadApp(String fileName) {
        ApplicationService.setFileData(getDataFromFile(fileName));
    }

    public FileData getDataFromFile(String fileName) {
        return readDataDAO.getDataFromFile(fileName);
    }
}
