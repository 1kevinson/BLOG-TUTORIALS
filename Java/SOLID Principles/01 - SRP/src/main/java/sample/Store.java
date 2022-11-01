package sample;

public class Store {

    private final Bill bill;

    public Store(Bill bill) {
        this.bill = bill;
    }

    void saveInFile() {
        // Save this.bill in File
    }

    void saveInDatabase() {
        // Save this.bill in Database
    }
}
