package sample.inheritance.concretion;

import sample.inheritance.contract.ElectronicCar;

public class Audi extends ElectronicCar {

    public Audi(String model, String color) {
        super("Audi", model, color);
    }

    // Audi car inherit of all the behaviours of parent ElectronicCar

    // Specific behavior of Audi E-Car
    public void unfoldRoof() {}
}
