package com.example.payments;

public class SafeCashAdapter implements PaymentGateway {
    private final SafeCashClient scc;

    public SafeCashAdapter(SafeCashClient scc) {
        this.scc = scc;
    }

    public String charge(String customerId, int amountCents){
        SafeCashPayment payment = scc.createPayment(amountCents, customerId);
        return payment.confirm();
    }
}

