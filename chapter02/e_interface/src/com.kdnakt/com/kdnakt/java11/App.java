package com.kdnakt.java11;

import java.util.Properties;

public class App {
    public static void main(String... arg) {
        double timeSec = 10.0;
        int horsePower = 246;
        int vehicleWeight = 4000;
        Properties drivingConditions = new Properties();
        drivingConditions.put("roadCondition", "Wet");
        drivingConditions.put("tireCondition", "New");
        SpeedModel speedModel = FactorySpeedModel.generateSpeedModel(drivingConditions);
        Car car = FactoryVehicle.buildCar(4, vehicleWeight, horsePower);
        car.setSpeedModel(speedModel);
        System.out.println("Car speed (" + timeSec + " sec) = " + car.getSpeedMph(timeSec) + " mph");
        Vehicle vehicle = FactoryVehicle.buildCrewCab(4, 3300, vehicleWeight, horsePower);
        vehicle.setSpeedModel(speedModel);
        System.out.println("Payload = " + ((Truck) vehicle).getPayloadPounds() + " pounds");
        System.out.println("Passengers count = " + ((Car) vehicle).getPassengersCount());
        System.out.println("Crew cab speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");
        horsePower = 246;
        int payload = Truck.convertKgToPounds(1500);
        vehicleWeight = Truck.convertKgToPounds(1800);
        Truck truck = FactoryVehicle.buildTruck(payload, vehicleWeight, horsePower);
        System.out.println("Payload in pounds: " + truck.getPayloadPounds());
        int kg = truck.getWeightKg(vehicleWeight);
        System.out.println("Payload converted to kg: " + kg);
        System.out.println("Payload converted back to pounds: " + Truck.convertKgToPounds(kg));
    }
}