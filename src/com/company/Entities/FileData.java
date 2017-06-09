package com.company.Entities;

import com.company.ApplicationService;
import com.company.DAO.ReadDataDAO;
import com.company.Service.LoadService;
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
public class FileData {
    /*существует два подхода: 1. сразу прочитать весь файл и иметь в памяти данные
    * 2. обращаться к файлу по потребности
    * я бы создала оба и протестировала быстродействие для каждого из них в дни разной загруженности системы
    * Здесь реализую первый. */

    /*
    Приму что у одного клиента только одна машина. В задании четко это не оговорено.
    Если машин может быть у одного клиента несколько,
    в этом случае надо создавать сущность Client и его класть в значение map
    //TODO сделать car и client не строкой, а объектом класса
     */
    /*
    А теперь вопрос, хранить в Map или в Set. Можно было создать сущность <Client, Car> и их хранить в Set.
    Но я решила разделить на Client, Car и их хранить в Map. Мне кажется, хранение сущностей по-отдельности
    предоставляет нам большую гибкость приложения.
     */

    private Map<String, String> clients;

    public FileData(Map<String, String> clients) {
        this.clients = clients;
    }

    public Map<String, String> getClients() {
        return clients;
    }

    public void setClients(Map<String, String> clients) {
        this.clients = clients;
    }

    public String getClient(String car){
        return clients.get(car);
    }

}
