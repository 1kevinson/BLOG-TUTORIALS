package sample;

public class Printer {

    private final Bill bill;

    public Printer(Bill bill) {
        this.bill = bill;
    }

    void printInkjet() {
        // Print this.bill with inkjet printer
    }

    void printLaser() {
        // Print this.bill with laser printer
    }
}
