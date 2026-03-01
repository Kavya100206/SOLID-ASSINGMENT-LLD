public class PaymentGateway implements PaymentService {

    @Override
    public String pay(double amount) {
        // keep existing logic
        return "TXN-9001";
    }
}