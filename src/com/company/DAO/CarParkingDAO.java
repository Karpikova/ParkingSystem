package com.company.DAO;

import com.company.ApplicationService;
import com.company.DataException;
import com.company.Entities.CarParkingInfo;

import java.util.Date;
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
public class CarParkingDAO implements CarParkingInterface {
    @Override
    public CarParkingInfo findParkedCar(Set<CarParkingInfo> shiftData, String car) throws DataException {
        Set<CarParkingInfo> appropriateEntities = new HashSet<>();
        CarParkingInfo theFirst = null;
        for (CarParkingInfo carParkingInfo:
             shiftData) {
            if (carParkingInfo.getCar().equals(car) && carParkingInfo.getFinish() == null){
                appropriateEntities.add(carParkingInfo);
                theFirst = carParkingInfo;
            }
        }
        if (appropriateEntities.size() == 1){
            return theFirst;
        }
        else if (appropriateEntities.size() > 1){
            //Мы знаем что такое никогда не должно произойти. Но если произошло - значит что-то пошло не так
            throw new DataException("Wrong structure of ApplicationService.CarParkingInfo");
        }
        else if(appropriateEntities.size() == 0)
        {
            System.out.println("Car hasn't arrived yet");
            return null;
        }
        return null;
    }

    @Override
    public void addCar(Set<CarParkingInfo> shiftData, CarParkingInfo carParkingInfo){
        for (CarParkingInfo carParkingInfoFromShift:
                shiftData) {
            if (carParkingInfoFromShift.getCar().equals(carParkingInfo.getCar()) && carParkingInfoFromShift.getFinish() == null)
            {
                System.out.println("Car is still here!");
                return;
            }
        }
        shiftData.add(carParkingInfo);
        System.out.println("Car is in.");
    }
}
