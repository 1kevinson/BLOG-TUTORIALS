package sample.inheritance.concretion;

import sample.inheritance.contract.ElectronicCar;

public class Ferrari {

    private final ElectronicCar electronicCar;

    // Compose using dependency injection
    public Ferrari(ElectronicCar electronicCar) {
        this.electronicCar = electronicCar;
    }

    // We can share common properties using the dependency
    public String getModel() {
        return this.electronicCar.getModel();
    }
}
