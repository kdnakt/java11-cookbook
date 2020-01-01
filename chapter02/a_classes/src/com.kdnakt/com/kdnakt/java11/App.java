package com.kdnakt.java11;

public class App {
    public static void main(String... arg) {
        double timeSec = 10.0;
        int horsePower = 246;
        int vehicleWeight = 4000;
        Engine engine = new Engine();
        engine.setHorsePower(horsePower);
        Vehicle vehicle = new Vehicle(vehicleWeight, engine);
        System.out.println("Vehicle speed (" + timeSec + " sec)=" + vehicle.getSpeedMph(timeSec) + " mph");
        try {
            new Vehicle(vehicleWeight, null);
        } catch (RuntimeException e) {
            if (e.getMessage().contains("Engine")) {
                System.out.println("Expected exception throw");
            } else {
                throw e;
            }
        }
        vehicle = new Car(4, vehicleWeight, engine);
        System.out.println("Car speed (" + timeSec + " sec) = " + vehicle.getSpeedMph(timeSec) + " mph");
    }
}