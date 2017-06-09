package com.company;

import com.company.DAO.CarParkingDAO;
import com.company.DAO.CarParkingInterface;
import com.company.Entities.CarParkingInfo;
import com.company.Entities.FileData;

import java.util.HashSet;
import java.util.Set;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public class ApplicationService {
    private static boolean toContinue = true;
    private static FileData fileData;
    private static Set<CarParkingInfo> shiftData = new HashSet<>();
    private static int price;

    public static boolean isToContinue() {
        return toContinue;
    }

    public static void setToContinue(boolean toContinue) {
        toContinue = toContinue;
    }

    public static FileData getFileData() {
        return fileData;
    }

    public static void setFileData(FileData fileData) {
        ApplicationService.fileData = fileData;
    }

    public static Set<CarParkingInfo> getShiftData() {
        return shiftData;
    }

    public static void addDataToShift(CarParkingInfo carParkingInfo) {
        shiftData.add(carParkingInfo);
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        ApplicationService.price = price;
    }
}
