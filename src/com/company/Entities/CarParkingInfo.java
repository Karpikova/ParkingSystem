package com.company.Entities;

import java.util.Date;

/*
 * ${Classname}
 * 
 * Version 1.0 
 * 
 * 09.06.2017
 * 
 * Karpikova
 */
public class CarParkingInfo {
    private String car;
    private Date start;
    private Date finish;

    public CarParkingInfo(String car, Date start, Date finish) {
        this.car = car;
        this.start = start;
        this.finish = finish;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }
}
