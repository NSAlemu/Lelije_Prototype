package org.lelije.lelijeprototype.Models;

import java.util.ArrayList;

public class ParentModel {
    private String firstName, MiddleName, lastName;
    private ArrayList<ChildModel> children;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<ChildModel> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<ChildModel> children) {
        this.children = children;
    }
}
