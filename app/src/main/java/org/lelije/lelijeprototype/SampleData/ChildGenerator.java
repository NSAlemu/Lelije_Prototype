package org.lelije.lelijeprototype.SampleData;

import org.lelije.lelijeprototype.Models.ChildModel;

import java.util.ArrayList;

public class ChildGenerator {
    public static ArrayList<ChildModel> generateChild(int amount) {
        ArrayList<ChildModel> ChildModelList = new ArrayList<ChildModel>();
        for(int i =0;i<amount;i++){
            ChildModelList.add(generateChild());
        }

        return ChildModelList;
    }

    public static ChildModel generateStaticChild(){
        ChildModel ChildModel = new ChildModel();
        ChildModel.setFirstName("Adil");
        ChildModel.setLastName("Mohammed");
        ChildModel.setLastName("Osman");
        ChildModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");

        return ChildModel;
    }
    public static ArrayList<ChildModel> generateStaticChildren(){
        ArrayList<ChildModel> ChildModelList = new ArrayList<ChildModel>();

        ChildModel ChildModel1 = new ChildModel();
        ChildModel1.setFirstName("Adil");
        ChildModel1.setLastName("Mohammed");
        ChildModel1.setLastName("Osman");
        ChildModel1.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");
        ChildModelList.add(ChildModel1);

        ChildModel ChildModel2 = new ChildModel();
        ChildModel2.setFirstName("Eman");
        ChildModel2.setLastName("Mohammed");
        ChildModel2.setLastName("Osman");
        ChildModel2.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");
        ChildModelList.add(ChildModel2);

        ChildModel ChildModel3 = new ChildModel();
        ChildModel3.setFirstName("Elias");
        ChildModel3.setLastName("Mohammed");
        ChildModel3.setLastName("Osman");
        ChildModel3.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");
        ChildModelList.add(ChildModel3);

        return ChildModelList;
    }
    private static ChildModel generateChild(){
        ChildModel ChildModel = new ChildModel();
        String name = NamesJSON.getRandomName();
        ChildModel.setFirstName(name.substring(0,name.indexOf(' ')-1));
        ChildModel.setLastName(name.substring(name.indexOf(' '),name.indexOf(' ',1)));
        ChildModel.setLastName(name.substring(name.indexOf(' ',1),name.indexOf(' ',2)));
        ChildModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");

        return ChildModel;
    }

}
