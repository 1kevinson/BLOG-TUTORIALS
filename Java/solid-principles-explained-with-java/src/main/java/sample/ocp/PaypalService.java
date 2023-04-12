package sample.ocp;

public class PaypalService {
    private final String credentials;

    public PaypalService(String credentials) {
        this.credentials = credentials;
    }

    public void receivePayment() {
        // connect to the PayPal API
        // transaction logic
        // ...
    }
}
