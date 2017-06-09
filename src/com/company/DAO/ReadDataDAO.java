package com.company.DAO;

import com.company.ApplicationService;
import com.company.Entities.FileData;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public class ReadDataDAO implements ReadDataDaoInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(ReadDataDAO.class));

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    @Override
    public FileData getDataFromFile(String fileName) {
        Map<String, String> preClients = new HashMap<>();
        String client;
        String car;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            while (reader.ready()) {
                String[] data = reader.readLine().split(";");
                client = data[0].trim();
                car = data[1].trim();
                if (preClients.containsKey(car)) {
                    System.out.println("Car " + car + " exists not once. That is not correct.");
                }
                preClients.put(car, client);
            }
        } catch (FileNotFoundException e) {
            logger.info(e.toString());
            System.out.println("Sorry, file not found. Check it exists");
            e.printStackTrace();
            ApplicationService.setToContinue(false);
        } catch (IOException e) {
            logger.info(e.toString());
            System.out.println("Sorry, IOExeption problem");
            e.printStackTrace();
            ApplicationService.setToContinue(false);
        }
        return new FileData(preClients);
    }
}
