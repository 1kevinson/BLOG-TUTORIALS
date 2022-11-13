package sample;

public class Printer {

    private final LaserPrinter laserPrinter;
    private final JetInkPrinter jetInkPrinter;

    public Printer(LaserPrinter laserPrinter, JetInkPrinter jetInkPrinter) {
        this.laserPrinter = laserPrinter;
        this.jetInkPrinter = jetInkPrinter;
    }

    void printInkjet(Bill bill) {
        // Print bill with inkjet printer
    }

    void printLaser(Bill bill) {
        // Print bill with laser printer
    }
}
