package sample.inheritance.concretion;

import sample.inheritance.contract.ElectronicCar;

public class Tesla extends ElectronicCar {

    public Tesla(String model, String color) {
        super("Tesla", model, color);
    }

    // Tesla car inherit of all the behaviours of parent ElectronicCar

    // Specific behaviours of Tesla E-Car
    public void turnOnTablet() {}

    public void turnOffTablet() {}
}
