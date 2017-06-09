package com.company;

import com.company.Service.HandlerService;
import com.company.Service.HandlerServiceInterface;
import com.company.Service.LoadService;
import com.company.Service.LoadServiceInterface;

public class Main {

    public static void main(String[] args) {
        //TODO Здесь еще при создании сущностей можно Spring IoC Прикрутить, получится слабосвязанно.
        LoadServiceInterface loadService = new LoadService();
        loadService.loadApp("test.txt");
        ApplicationService.setPrice(100);
        HandlerServiceInterface handlerServiceInterface = new HandlerService();
        handlerServiceInterface.startApp();
    }
}
