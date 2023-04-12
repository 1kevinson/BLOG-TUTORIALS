package sample.lsp;

public interface PaymentService {
    void pay(String company,int quantity);
}

class PaymentController extends BaseController {
    private final PaymentService paymentService;

    PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void executePayment() {
        // handle third party request
        // ...
        // make payment
        String company = "randomCompany";
        int quantity = (int) (Math.random() * 10);
        this.paymentService.pay(company, quantity);
    }
}