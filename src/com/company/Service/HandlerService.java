package com.company.Service;

import com.company.ApplicationService;
import com.company.DAO.CarParkingDAO;
import com.company.DAO.CarParkingInterface;
import com.company.DAO.ReadDataDAO;
import com.company.DataException;
import com.company.Entities.CarParkingInfo;
import org.apache.log4j.PropertyConfigurator;

import java.util.Date;
import java.util.Scanner;
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
public class HandlerService implements HandlerServiceInterface{

    private static final Logger logger = Logger.getLogger(String.valueOf(HandlerService.class));

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    CarParkingInterface carParkingInterface = new CarParkingDAO();

    @Override
    public void startApp() {

        Scanner in = new Scanner(System.in);
        System.out.println("You are welcome in Parking App");
        String line = "";

        while (ApplicationService.isToContinue()){
            System.out.println("Enter your command here:");
            line = in.nextLine();
            String[] usersCommand = line.split(" ");
            String whatToDo = usersCommand[0];
            if (whatToDo.equals("in")) {
                carIn(usersCommand[1]);
            }
            else if (whatToDo.equals("out")) {
                try {
                    carOut(usersCommand[1]);
                } catch (DataException e) {
                    logger.info(e.getMessage());
                }
            }
            else if (whatToDo.equals("report")) {
                printReport();
            }
            else {
                System.out.println("Sorry, we didn't recognize your command. Could you please try again?");
            }

        }
    }

    @Override
    public void printReport() {
        double toPay;
        int price = ApplicationService.getPrice();
        int minutes = 60;
        for (CarParkingInfo carParkingInfo : ApplicationService.getShiftData()) {
            if (carParkingInfo.getFinish() == null)
            {
                System.out.println(carParkingInfo.getCar() + " is still here.");
                continue;
            }
            toPay = (carParkingInfo.getFinish().getTime() - carParkingInfo.getStart().getTime()) * price / minutes;
            System.out.println(carParkingInfo.getCar() + " gotta pay " + toPay + ".");
        }
    }

    @Override
    public void carOut(String car) throws DataException {
        String client = findAClient(car);
        if (client != null)
        {
            CarParkingInfo carParkingInfo = carParkingInterface.findParkedCar(ApplicationService.getShiftData(), car);
            if (carParkingInfo != null) {
                carParkingInfo.setFinish(new Date());
                System.out.println("Car is out.");
            }
        }
        else {
            System.out.println("Car is not found in the data base");
        }
    }

    @Override
    public void carIn(String car) {
        String client = findAClient(car);
        if (client != null)
        {
            carParkingInterface.addCar(ApplicationService.getShiftData(), new CarParkingInfo(car, new Date(), null));
        }
        else {
            System.out.println("Car is not found in the data base");
        }
    }

    private static String findAClient(String car) {
        return ApplicationService.getFileData().getClient(car);
    }
}
