package sample;

public class Store {

    private final Bill bill;

    public Store(Bill bill) {
        this.bill = bill;
    }

    void saveBill() {
        // Save this.bill in FileStore or Database Store
    }
}
