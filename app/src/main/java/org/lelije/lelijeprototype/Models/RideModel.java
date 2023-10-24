package org.lelije.lelijeprototype.Models;

import java.util.Date;

public class RideModel {
    public boolean isOneWay;
    public Date scheduledPickupTime, scheduledDropoffTime;
    public String scheduledPickupLocation, scheduledDropoffLocation;
    DriverModel driver;
    ParentModel parent;

    public boolean isOneWay() {
        return isOneWay;
    }

    public void setOneWay(boolean oneWay) {
        isOneWay = oneWay;
    }

    public Date getScheduledPickupTime() {
        return scheduledPickupTime;
    }

    public void setScheduledPickupTime(Date scheduledPickupTime) {
        this.scheduledPickupTime = scheduledPickupTime;
    }

    public Date getScheduledDropoffTime() {
        return scheduledDropoffTime;
    }

    public void setScheduledDropoffTime(Date scheduledDropoffTime) {
        this.scheduledDropoffTime = scheduledDropoffTime;
    }

    public String getScheduledPickupLocation() {
        return scheduledPickupLocation;
    }

    public void setScheduledPickupLocation(String scheduledPickupLocation) {
        this.scheduledPickupLocation = scheduledPickupLocation;
    }

    public String getScheduledDropoffLocation() {
        return scheduledDropoffLocation;
    }

    public void setScheduledDropoffLocation(String scheduledDropoffLocation) {
        this.scheduledDropoffLocation = scheduledDropoffLocation;
    }

    public DriverModel getDriver() {
        return driver;
    }

    public void setDriver(DriverModel driver) {
        this.driver = driver;
    }

    public ParentModel getParent() {
        return parent;
    }

    public void setParent(ParentModel parent) {
        this.parent = parent;
    }
}
