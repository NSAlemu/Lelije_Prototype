package org.lelije.lelijeprototype.SampleData;

import org.lelije.lelijeprototype.Models.DriverModel;

import java.util.ArrayList;

public class DriverGenerator {
    public static ArrayList<DriverModel> generateDriver(int amount) {
        ArrayList<DriverModel> driverModelList = new ArrayList<>();
        for(int i =0;i<amount;i++){
            driverModelList.add(generateDriver());
        }

        return driverModelList;
    }

    public static DriverModel generateStaticDriver(){
        DriverModel driverModel = new DriverModel();
        driverModel.setFirstName("Meklit");
        driverModel.setLastName("Nega");
        driverModel.setLastName("Bekele");
        driverModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");

        return driverModel;
    }
    private static DriverModel generateDriver(){
        DriverModel driverModel = new DriverModel();
        String name = NamesJSON.getRandomName();
        String[] splited = name.split("\\s+");

        driverModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");
        driverModel.setFirstName(splited[0]);
        driverModel.setMiddleName(splited[1]);
        driverModel.setLastName(splited[2]);
        return driverModel;
    }

}
