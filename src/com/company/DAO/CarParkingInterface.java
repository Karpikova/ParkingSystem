package com.company.DAO;

import com.company.DataException;
import com.company.Entities.CarParkingInfo;

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
public interface CarParkingInterface {
    CarParkingInfo findParkedCar(Set<CarParkingInfo> shiftData, String car) throws DataException;
    void addCar(Set<CarParkingInfo> shiftData, CarParkingInfo carParkingInfo);
}
