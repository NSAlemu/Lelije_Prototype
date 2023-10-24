package org.lelije.lelijeprototype.SampleData;

import org.lelije.lelijeprototype.Models.RideModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class RideGenerator {
    public static ArrayList<RideModel> generatePreviousRides(int amount) {
        ArrayList<RideModel> rides = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            rides.add(generateRideForward(1+i, 0));
            rides.add(generateRideBack(1+i, 0));
        }
        return rides;
    }

    public static RideModel generateCurrentRide(){
        return generateRideToday();
    }

    public static ArrayList<RideModel> generateFutureRides(int amount) {
        ArrayList<RideModel> rides = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            rides.add(generateRideForward(0, 1+i));
            rides.add(generateRideBack(0, i+1));
        }
        return rides;
    }

    private static RideModel generateRideForward(int howFarBack, int howFarForward) {
        RideModel rideModel = new RideModel();
        rideModel.setDriver(DriverGenerator.generateStaticDriver());
        rideModel.setParent(ParentGenerator.generateStaticParent());
        rideModel.setOneWay(false);
        rideModel.setScheduledPickupLocation("Imperial Gerji, Addis Ababa, Ethiopia");
        rideModel.setScheduledDropoffLocation("School of Tomorrow, CMC, Addis Ababa, Ethiopia");
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.add(Calendar.DATE, howFarForward - howFarBack);
        cal1.add(Calendar.HOUR_OF_DAY, 8);
        cal1.add(Calendar.MINUTE, 30);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, howFarForward - howFarBack);
        cal2.add(Calendar.HOUR_OF_DAY, 9);
        cal2.add(Calendar.MINUTE, 0);

        rideModel.setScheduledDropoffTime(cal1.getTime());
        rideModel.setScheduledPickupTime(cal2.getTime());


        return rideModel;
    }

    private static RideModel generateRideBack(int howFarBack, int howFarForward) {
        RideModel rideModel = new RideModel();
        rideModel.setDriver(DriverGenerator.generateStaticDriver());
        rideModel.setParent(ParentGenerator.generateStaticParent());
        rideModel.setOneWay(false);
        rideModel.setScheduledDropoffLocation("Imperial Gerji, Addis Ababa, Ethiopia");
        rideModel.setScheduledPickupLocation("School of Tomorrow, CMC, Addis Ababa, Ethiopia");
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.add(Calendar.DATE, howFarForward - howFarBack);
        cal1.add(Calendar.HOUR_OF_DAY, 16);
        cal1.add(Calendar.MINUTE, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.DATE, howFarForward - howFarBack);
        cal2.add(Calendar.HOUR_OF_DAY, 16);
        cal2.add(Calendar.MINUTE, 30);

        rideModel.setScheduledDropoffTime(cal1.getTime());
        rideModel.setScheduledPickupTime(cal2.getTime());


        return rideModel;
    }

    private static RideModel generateRideToday() {
        RideModel rideModel = new RideModel();
        rideModel.setDriver(DriverGenerator.generateStaticDriver());
        rideModel.setParent(ParentGenerator.generateStaticParent());
        rideModel.setOneWay(false);
        rideModel.setScheduledDropoffLocation("Imperial Gerji, Addis Ababa, Ethiopia");
        rideModel.setScheduledPickupLocation("School of Tomorrow, CMC, Addis Ababa, Ethiopia");
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(new Date());
        cal1.add(Calendar.HOUR_OF_DAY, 16);
        cal1.add(Calendar.MINUTE, 0);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.add(Calendar.HOUR_OF_DAY, 16);
        cal2.add(Calendar.MINUTE, 30);

        rideModel.setScheduledDropoffTime(cal1.getTime());
        rideModel.setScheduledPickupTime(cal2.getTime());


        return rideModel;
    }
}
