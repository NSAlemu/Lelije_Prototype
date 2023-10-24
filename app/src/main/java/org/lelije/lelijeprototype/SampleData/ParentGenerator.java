package org.lelije.lelijeprototype.SampleData;

import org.lelije.lelijeprototype.Models.ParentModel;

import java.util.ArrayList;

public class ParentGenerator {
    public static ArrayList<ParentModel> generateParent(int amount) {
        ArrayList<ParentModel> ParentModelList = new ArrayList<>();
        for(int i =0;i<amount;i++){
            ParentModelList.add(generateParent());
        }

        return ParentModelList;
    }

    public static ParentModel generateStaticParent(){
        ParentModel parentModel = new ParentModel();
        parentModel.setFirstName("Mohammed");
        parentModel.setLastName("Osman");
        parentModel.setLastName("Ismail");
        parentModel.setChildren(ChildGenerator.generateStaticChildren());

//        ParentModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");

        return parentModel;
    }
    private static ParentModel generateParent(){
        ParentModel parentModel = new ParentModel();
        String name = NamesJSON.getRandomName();
        parentModel.setFirstName(name.substring(0,name.indexOf(' ')-1));
        parentModel.setLastName(name.substring(name.indexOf(' '),name.indexOf(' ',1)));
        parentModel.setLastName(name.substring(name.indexOf(' ',1),name.indexOf(' ',2)));
//        ParentModel.setImageURL("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcSd0WZC1MCEvzqUgH3al0qYG57dPK-7uOZboZQ-LufpjPSNqvlz");
        parentModel.setChildren(ChildGenerator.generateChild(3));
        return parentModel;
    }

}
