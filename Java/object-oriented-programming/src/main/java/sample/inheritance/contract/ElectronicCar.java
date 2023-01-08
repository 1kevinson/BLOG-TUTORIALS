package sample.inheritance.contract;

public abstract class ElectronicCar {

    // Every car share those common properties
    protected String name;
    protected String model;
    protected String color;

    public ElectronicCar(String name, String model, String color) {
        this.name = name;
        this.model = model;
        this.color = color;
    }

    // and those behaviours
    public void start() {}
    public void playMusic() {}
    public void runAirConditioning() {}
}
