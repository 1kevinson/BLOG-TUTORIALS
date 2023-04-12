package sample.lsp;

public class concretions {
}

class PayPal implements PaymentService {
    @Override
    public void pay(String company, int quantity) {
        // paypal algorithm
    }
}

class Stripe implements PaymentService {
    @Override
    public void pay(String company, int quantity) {
        // stripe algorithm
    }
}

class Visa implements PaymentService {
    @Override
    public void pay(String company, int quantity) {
        // visa algorithm
    }
}

class PurchaseController {
    private final PaymentService paymentService;

    PurchaseController(PaymentService paymentService) { // Like this
        this.paymentService = paymentService;
    }

    public void executePayment(String company, int quantity) {
        // handle API request
        // ...
        this.paymentService.pay(company, quantity);
    }
}

class Demo {
    public static void main(String[] args) {
        var paypalService = new PayPal();
        var stripe = new Stripe();
        var visa = new Visa();

        // any of these are valid
        PurchaseController purchaseController1 = new PurchaseController(paypalService);
        // or
        PurchaseController purchaseController2 = new PurchaseController(stripe);
        // or
        PurchaseController purchaseController3 = new PurchaseController(visa);
    }
}